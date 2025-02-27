package com.mb.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        log.info("Handling hello request");
        return "Hello, World!";
    }
}
