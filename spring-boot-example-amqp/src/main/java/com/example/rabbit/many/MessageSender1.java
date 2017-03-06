package com.example.rabbit.many;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender1 {

    private static Logger logger = Logger.getLogger(MessageSender1.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend("many", message);
        logger.info(String.format("send(1) message: %s", message));
    }

}
