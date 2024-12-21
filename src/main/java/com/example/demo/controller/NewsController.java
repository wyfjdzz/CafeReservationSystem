package com.example.demo.controller;

import com.example.demo.domain.New;
import com.example.demo.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NewsController {
  @Autowired
  private NewService newService;

  @RequestMapping("/news_All")
  public String newsAll(Model model) {
    List<New> newList = newService.getAllNews();
    model.addAttribute("newList", newList);
    return "html/news/news_All";
  }

  @RequestMapping("/news_Detail")
  public String newDetail() { return "html/news/news_Detail"; }
}
