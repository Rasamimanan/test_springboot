package com.example.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping("/")
    public String home() {
        return "Application mandeha tsara! ouiiiiii 🎉";
    }

    @GetMapping("/test")
    public String test() {
        return "Ity ny test page!";
    }
    @GetMapping("/style")
    public String style() {
        return "style vaovao";
    }
}
