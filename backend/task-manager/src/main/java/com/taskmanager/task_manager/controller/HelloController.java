package com.taskmanager.task_manager.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Your Task Manager API is working.";
    }
}
