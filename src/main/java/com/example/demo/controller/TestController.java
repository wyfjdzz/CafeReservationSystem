package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
  @RequestMapping("/login")
  public String login() {
    return "html/user/login";
  }
  @RequestMapping("/register")
  public String register() {
    return "html/user/register";
  }
  @RequestMapping("/succeed")
  public String succeed() {
    return "html/user/succeed";
  }


}
