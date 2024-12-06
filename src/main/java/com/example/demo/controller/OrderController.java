package com.example.demo.controller;

import com.example.demo.domain.UserDesk;
import com.example.demo.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping("User/Order")
  public String Order(@ModelAttribute UserDesk userDesk, HttpSession session) {
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
      return "redirect:/login";
    }
    userDesk.setUserId(userId);
    orderService.addOrder(userDesk);
    return "redirect:/succeed";
  }

}
