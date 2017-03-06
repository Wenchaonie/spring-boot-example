package com.example.rabbit;

import com.example.rabbit.many.MessageSender1;
import com.example.rabbit.many.MessageSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

    @Autowired
    private MessageSender1 messageSender1;
    @Autowired
    private MessageSender2 messageSender2;

    @Test
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            messageSender1.send(String.format("hello world(%d)", i));
        }
    }

    @Test
    public void manyToMany() {
        for (int i = 0; i < 20; i++) {
            messageSender1.send(String.format("hello world(%d)", i));
            messageSender2.send(String.format("hello world(%d)", i));
        }
    }

}
