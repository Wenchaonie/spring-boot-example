package com.example;

import org.apache.log4j.Logger;
import org.apache.rocketmq.spring.starter.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.starter.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "hello", consumerGroup = "consumer-test")
public class HelloReceiver implements RocketMQListener<String> {

    private static Logger logger = Logger.getLogger(HelloReceiver.class);

    @Override
    public void onMessage(String message) {
        logger.info(String.format("consume message: %s", message));
    }
}
