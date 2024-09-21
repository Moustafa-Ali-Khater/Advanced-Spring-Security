package com.spring.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swimming")
@RequiredArgsConstructor
public class SwimmingConroller {

    @DeleteMapping("/start")
    public String start() {
        return "This show swimming controller";
    }
}
