package com.iamgkt.spring.concurrency.poc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieTicketService {

    private final MovieTicketDao movieTicketDao;


    public synchronized void bookTicket(MovieTicket movieTicket) {
        movieTicketDao.save(movieTicket);
    }


    public MovieTicket getTicketById(Long ticketId) {
        return movieTicketDao.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("Movie ticket with ID " + ticketId + " not found"));
    }

}
