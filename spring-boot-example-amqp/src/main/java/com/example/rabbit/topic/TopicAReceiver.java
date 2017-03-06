package com.example.rabbit.topic;

import com.example.rabbit.object.ObjectReceiver;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicAReceiver {

    private static Logger logger = Logger.getLogger(ObjectReceiver.class);

    @RabbitListener(queues = "topic.a")
    public void process(String message) {
        logger.info(String.format("receive topic a message: %s", message));
    }

}
