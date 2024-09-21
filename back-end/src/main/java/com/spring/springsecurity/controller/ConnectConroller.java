package com.spring.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connect")
@RequiredArgsConstructor
public class ConnectConroller {

    @GetMapping("/start")
    public String start() {
        return "This show connect controller";
    }
}
