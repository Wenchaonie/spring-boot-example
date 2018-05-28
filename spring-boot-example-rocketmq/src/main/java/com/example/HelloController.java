package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private HelloSender helloSender;

    @GetMapping("/sayHello")
    public String sayHello() {
        String message = "Hello World";
        helloSender.send(message);
        return message;
    }

}
