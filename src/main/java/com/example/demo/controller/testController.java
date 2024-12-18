package com.example.demo.controller;

import org.springframework.stereotype.Controller;
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
  @RequestMapping("/deskGame_Detail")
  public String deskGame_Detail() {return "html/deskGame_Detail";}
  @RequestMapping("/deskGame_Reserve")
  public String deskGame_Reserve() {
    return "html/deskGame_Reserve";
  }

  @RequestMapping("/news_All")
  public String news_All() {
    return "html/news_All";
  }
  @RequestMapping("/news_Detail")
  public String news_Detail() {
    return "html/news_Detail";
  }


  @RequestMapping("/Manager_MainPage")
  public String Manager_MainPage() {
    return "html/Manager_MainPage";
  }

  @RequestMapping("/Manager_OrderAll")
  public String Manager_OrderAll() {
    return "html/Manager_OrderAll";
  }

  @RequestMapping("/Manager_GameManage_SelectManageType")
  public String Manager_SelectManageType() {
    return "html/Manager_GameManage_SelectManageType";
  }
  @RequestMapping("/Manager_GameManage_Delete")
  public String Manager_GameManage_Delete() {
    return "html/Manager_GameManage_Delete";
  }
  @RequestMapping("/Manager_GameManage_Update")
  public String Manager_GameManage_Update() {return "html/Manager_GameManage_Update";}
  @RequestMapping("/Manager_GameManage_Upload")
  public String Manager_GameManage_Upload() {
    return "html/Manager_GameManage_Upload";
  }
  @RequestMapping("/Manager_GameManage_Success")
  public String Manager_GameManage_Success() {
    return "html/Manager_GameManage_Success";
  }


  @RequestMapping("/Manager_UserAll")
  public String Manager_UserAll() {
    return "html/Manager_UserAll";
  }


}
