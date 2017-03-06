package com.example.rabbit.many;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "many")
public class MessageReceiver1 {

    private static Logger logger = Logger.getLogger(MessageReceiver1.class);

    @RabbitHandler
    public void process(String message) {
        logger.info(String.format("receive(1) message: %s", message));
    }

}
