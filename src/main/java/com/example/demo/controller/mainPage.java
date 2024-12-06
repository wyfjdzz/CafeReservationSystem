package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mainPage")
public class mainPage{
    @RequestMapping("/mainPage")
    public String mp() {
        return "html/mainPage";
    }
}
