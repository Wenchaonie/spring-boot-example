package com.example.rabbit;

import com.example.rabbit.topic.TopicASender;
import com.example.rabbit.topic.TopicAnySender;
import com.example.rabbit.topic.TopicBSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicASender topicASender;
    @Autowired
    private TopicBSender topicBSender;
    @Autowired
    private TopicAnySender topicAnySender;

    @Test
    public void topicA() {
        topicASender.send("hello world");
    }

    @Test
    public void topicB() {
        topicBSender.send("hello world");
    }

    @Test
    public void topicAny() {
        topicAnySender.send("hello world");
    }

}
