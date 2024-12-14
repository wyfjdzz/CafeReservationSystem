package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class testController {
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
  @RequestMapping("/mainPage")
  public String mp() {
    return "html/mainPage";
  }
  @RequestMapping("/deskOrder_FirstSelect")
  public String do_fs() {
    return "html/deskOrder_FirstSelect";
  }
  @RequestMapping("/deskOrder_OrderDetails")
  public String do_od() {return "html/deskOrder_OrderDetails";}
  @RequestMapping("/deskOrder_SelectDesk")
  public String do_sd() {return "html/deskOrder_SelectDesk";}
  @RequestMapping("/deskOrder_SelectTime")
  public String do_st() {
    return "html/deskOrder_SelectTime";
  }

    @RequestMapping("/deskGame_All")
  public String deskGame_All() {
    return "html/deskGame_All";
  }
  @RequestMapping("/deskGame_Detail")
  public String deskGame_Detail() {
    return "html/deskGame_Detail";
  }
  @RequestMapping("/deskGame_Reserve")
  public String deskGame_Reserve() {
    return "html/deskGame_Reserve";
  }


}
