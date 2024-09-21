package com.spring.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basketball")
@RequiredArgsConstructor
public class BasketballConroller {

    @PostMapping("/start")
    public String start() {
        return "This show basketball controller";
    }
}
