package com.steven.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "steven")
public class StevenReceiver1 {

    @RabbitHandler
    public void process(String Steven) {
        System.out.println("Receiver 1: " + Steven);
    }

}
