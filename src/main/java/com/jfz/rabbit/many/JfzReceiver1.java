package com.jfz.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "jfz")
public class JfzReceiver1 {

    @RabbitHandler
    public void process(String jfz) {
        System.out.println("Receiver 1: " + jfz);
    }

}