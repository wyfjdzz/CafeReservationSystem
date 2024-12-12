package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
  @RequestMapping("/login")
  public String login() {
    return "html/login";
  }
  @RequestMapping("/register")
  public String register() {
    return "html/register";
  }
  @RequestMapping("/order")
  public String order() {
    return "html/order";
  }
  @RequestMapping("/succeed")
  public String succeed() {
    return "html/succeed";
  }


}
