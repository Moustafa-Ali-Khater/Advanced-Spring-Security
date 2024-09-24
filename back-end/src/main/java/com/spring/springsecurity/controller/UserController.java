package com.spring.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user")
    public String start() {
        return "I'm User Welcom to me";
    }
}
