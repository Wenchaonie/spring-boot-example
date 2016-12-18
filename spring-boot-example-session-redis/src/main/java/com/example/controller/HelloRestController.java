package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class HelloRestController {

    @RequestMapping("/uuid")
    public String uuid(HttpSession session) {
        UUID uuid = (UUID) session.getAttribute("uuid");
        if (uuid == null) {
            uuid = UUID.randomUUID();
            session.setAttribute("uuid", uuid);
        }
        return uuid.toString();
    }

}
