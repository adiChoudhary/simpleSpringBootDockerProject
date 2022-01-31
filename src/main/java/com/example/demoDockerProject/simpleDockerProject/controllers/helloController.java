package com.example.demoDockerProject.simpleDockerProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @GetMapping("/")
    public String index(){
        return "Hello World";
    }
}
