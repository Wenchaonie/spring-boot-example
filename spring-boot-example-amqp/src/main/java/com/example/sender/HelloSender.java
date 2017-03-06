package com.example.sender;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    private static Logger logger = Logger.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "hello world";
        rabbitTemplate.convertAndSend("hello", message);
        logger.info(String.format("send message: %s", message));
    }

}
