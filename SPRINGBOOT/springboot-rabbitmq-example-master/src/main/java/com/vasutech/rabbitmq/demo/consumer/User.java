package com.vasutech.rabbitmq.demo.consumer;

import com.vasutech.rabbitmq.demo.config.MessagingConfig;
import com.vasutech.rabbitmq.demo.dto.OrderStatus;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

//    @RabbitListener(queues = MessagingConfig.QUEUE)
//    public void consumeMessageFromQueue(OrderStatus orderStatus) {
//        System.out.println("Message recieved from queue : " + orderStatus);
//    }
}
