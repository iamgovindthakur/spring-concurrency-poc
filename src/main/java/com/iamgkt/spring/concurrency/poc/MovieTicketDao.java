package com.iamgkt.spring.concurrency.poc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTicketDao extends JpaRepository<MovieTicket, Long> {
    // You can define custom query methods here if needed
}
