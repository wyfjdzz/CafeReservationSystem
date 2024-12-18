package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class testController {
  @RequestMapping("/test")
  public String test() {
    return "html/test";
  }

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

  @RequestMapping("/deskOrder_FirstSelect")
  public String deskOrder_FirstSelect() {return "html/deskOrder_FirstSelect";}
  @RequestMapping("/deskOrder_SelectTime")
  public String deskOrder_SelectTime() {return "html/deskOrder_SelectTime";}
  @RequestMapping("/deskOrder_OrderSuccess")
  public String deskOrder_OrderSuccess() {return "html/deskOrder_OrderSuccess";}


  @RequestMapping("/deskGame_All")
  public String deskGame_All() {
    return "html/deskGame_All";
  }
  @RequestMapping("/deskGame_Detail.html")
  public String deskGame_Detail() {
    return "html/deskGame_Detail";
  }
  @RequestMapping("/deskGame_Reserve")
  public String deskGame_Reserve() {
    return "html/deskGame_Reserve";
  }



}
