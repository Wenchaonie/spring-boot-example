package com.example.rabbit.object;

import com.example.model.User;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

    private static Logger logger = Logger.getLogger(ObjectSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        rabbitTemplate.convertAndSend("object", user);
        logger.info(String.format("send object: %s", user));
    }

}
