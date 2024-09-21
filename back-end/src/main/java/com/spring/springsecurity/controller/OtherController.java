package com.spring.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/other")
@RequiredArgsConstructor
public class OtherController {

    @PostMapping("/start")
    public String start() {
        return "Write What you see";
    }
}
