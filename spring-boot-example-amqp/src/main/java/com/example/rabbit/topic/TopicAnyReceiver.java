package com.example.rabbit.topic;

import com.example.rabbit.object.ObjectReceiver;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicAnyReceiver {

    private static Logger logger = Logger.getLogger(ObjectReceiver.class);

    @RabbitListener(queues = "topic.any")
    public void process(String message) {
        logger.info(String.format("receive topic any message: %s", message));
    }

}
