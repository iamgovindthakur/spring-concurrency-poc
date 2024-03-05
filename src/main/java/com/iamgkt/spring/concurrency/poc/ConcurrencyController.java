package com.iamgkt.spring.concurrency.poc;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ConcurrencyController {

    private final MovieTicketService movieTicketService;

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);


    @PostMapping(value = "/bookseat")
    @SneakyThrows
    public ConcurrencyResponse bookMyTicket()  {
        readWriteLock.writeLock().lock();
        MovieTicket movieTicket = movieTicketService.getTicketById(Long.valueOf("1"));
        if (movieTicket.getAvailableTickets() > 0) {
            Thread.sleep(3000);
            movieTicket.setAvailableTickets(movieTicket.getAvailableTickets()-1);
            movieTicketService.bookTicket(movieTicket);
            log.info(Thread.currentThread() + ": Booking Successful");
            readWriteLock.writeLock().unlock();
            return ConcurrencyResponse.builder().movieTicket(movieTicket).message("Booking Successful").statusCode(HttpStatus.CREATED).build();
        }
        return ConcurrencyResponse.builder().movieTicket(movieTicket).message("No Seat Left").statusCode(HttpStatus.INSUFFICIENT_STORAGE).build();

    }

    @GetMapping("/getseat")
    public MovieTicket getAvailableSeats() {
        return movieTicketService.getTicketById(1L);
    }


}
