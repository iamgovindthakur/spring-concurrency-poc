package com.iamgkt.spring.concurrency.poc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RequiredArgsConstructor
public class ConcurrencyPocApplication implements CommandLineRunner {

    //private final MovieTicketDao movieTicketDao;
    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyPocApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //movieTicketDao.save(MovieTicket.builder().movieName("DDLJ").availableTickets(10L).build());
    }
}
