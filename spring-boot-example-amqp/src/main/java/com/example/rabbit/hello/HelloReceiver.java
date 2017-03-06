package com.example.rabbit.hello;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    private static Logger logger = Logger.getLogger(HelloReceiver.class);

    @RabbitHandler
    public void process(String message) {
        logger.info(String.format("receive message: %s", message));
    }

}
