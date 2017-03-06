package com.example.rabbit.object;

import com.example.model.User;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ObjectReceiver {

    private static Logger logger = Logger.getLogger(ObjectReceiver.class);

    @RabbitListener(queues = "object")
    public void process(User user) {
        logger.info(String.format("receive object: %s", user));
    }

}
