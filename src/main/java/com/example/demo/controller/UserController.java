package com.example.demo.controller;

import com.example.demo.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

  @Autowired
  private com.example.demo.service.UserService UserService;

  @PostMapping("User/register")
  public String Register(@ModelAttribute User user) {

    UserService.addUser(user);
    return "redirect:/login";
  }

  @PostMapping("User/login")
  public String Login(@ModelAttribute User user, HttpSession session) {
    int userId = UserService.login(user.getuserName(),user.getuserPassword());
    if (userId != 0) {
      session.setAttribute("userId", userId);
      return "redirect:/mainPage";
    }
    return "redirect:/login";
  }


}
