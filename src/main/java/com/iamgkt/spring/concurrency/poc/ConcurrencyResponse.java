package com.iamgkt.spring.concurrency.poc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConcurrencyResponse {
    MovieTicket movieTicket;
    String message;
    HttpStatus statusCode;
}
