package com.programming.techie.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSender {

    public void sendEmail(OrderDto orderDto) throws InterruptedException {
        log.info("Sending Email Confirmation for Order - {}", orderDto.getOrderNumber());
        Thread.sleep(100);
        log.info("Email Sent!!");
    }
}
