package com.steven.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue stevenQueue() {
        return new Queue("steven");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }


}
