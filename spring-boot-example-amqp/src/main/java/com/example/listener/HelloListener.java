package com.example.listener;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloListener {

    private static Logger logger = Logger.getLogger(HelloListener.class);

    @RabbitHandler
    public void process(String message) {
        logger.info(String.format("receive message: %s", message));
    }

}
