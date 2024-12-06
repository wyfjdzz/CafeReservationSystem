package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.servicelmpl.UserServicelmpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

  @Autowired
  private UserServicelmpl UserService;

  @PostMapping("User/register")
  public String Register(@ModelAttribute User user) {

    UserService.addUser(user);
    return "redirect:/login";
  }

  @PostMapping("User/login")
  public String Login(@ModelAttribute User user, HttpSession session) {
    Integer userId = UserService.login(user.getuserName(),user.getuserPassword());
    if (userId != 0) {
      session.setAttribute("userId", userId);
      return "redirect:/order";
    }
    return "redirect:/login";
  }

  @RequestMapping("/exa")
  public String exa(Model model) {
    model.addAttribute("message", "Hello, World!");
    return "html/exa";
  }
}
