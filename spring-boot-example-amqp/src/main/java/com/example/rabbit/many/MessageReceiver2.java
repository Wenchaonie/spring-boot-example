package com.example.rabbit.many;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "many")
public class MessageReceiver2 {

    private static Logger logger = Logger.getLogger(MessageReceiver2.class);

    @RabbitHandler
    public void process(String message) {
        logger.info(String.format("receive(2) message: %s", message));
    }

}
