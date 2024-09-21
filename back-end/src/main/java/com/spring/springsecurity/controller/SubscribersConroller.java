package com.spring.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class SubscribersConroller {

    @PutMapping("/start")
    public String start() {
        return "This show subscribers controller";
    }
}
