package com.example.rabbit.fanout;

import com.example.rabbit.object.ObjectReceiver;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutAReceiver {

    private static Logger logger = Logger.getLogger(ObjectReceiver.class);

    @RabbitListener(queues = "fanout.a")
    public void process(String message) {
        logger.info(String.format("receive fanout a message: %s", message));
    }

}
