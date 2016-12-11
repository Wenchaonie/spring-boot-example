package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/sid")
    public String sid(HttpSession session) {
        return session.getId();
    }

}
