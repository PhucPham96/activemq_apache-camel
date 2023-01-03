package com.example.activeMQ.controller;

import com.example.activeMQ.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final Producer producer;

    @GetMapping("/hello")
    public String init(@RequestParam String message) {
        producer.sendMessage(message);
        return "Hello";
    }
}
