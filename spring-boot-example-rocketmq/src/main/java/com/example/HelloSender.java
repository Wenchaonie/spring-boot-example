package com.example;

import org.apache.log4j.Logger;
import org.apache.rocketmq.spring.starter.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    private static Logger logger = Logger.getLogger(HelloSender.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void send(String message) {
        rocketMQTemplate.convertAndSend("hello", message);
        logger.info(String.format("send message: %s", message));
    }

}
