package com.example.demo.controller;

import com.example.demo.domain.Game;
import com.example.demo.domain.User;
import com.example.demo.domain.UserDesk;
import com.example.demo.domain.UserGame;
import com.example.demo.service.servicelmpl.GameServicelmpl;
import com.example.demo.service.servicelmpl.UserDeskServicelmpl;
import com.example.demo.service.servicelmpl.UserGameServicelmpl;
import com.example.demo.service.servicelmpl.UserServicelmpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

  @Autowired
  private UserDeskServicelmpl userDeskService;
  @Autowired
  private UserGameServicelmpl userGameService;
  @Autowired
  private GameServicelmpl gameService;
  @Autowired
  private UserServicelmpl userService;

  @RequestMapping("/mainPage")
  public String mainPage(Model model, HttpSession session) {

    Integer userId = (Integer) session.getAttribute("userId");

    if (userId == null) {
      return "redirect:/login";
    }

    try {
      User user = userService.findUserById(userId);
      model.addAttribute("user", user);
    }
    catch (Exception e) {
      User user = new User();
      model.addAttribute("user", user);
    }

    try {
      List<UserDesk> historyUserDesk = userDeskService.getAllUserDeskByUserId(userId);
      List<UserDesk> newHistoryUserDesk = historyUserDesk.subList(historyUserDesk.size() - 2, historyUserDesk.size());
      model.addAttribute("historyUserDesk",newHistoryUserDesk);
    }
    catch (Exception e) {
      List<UserDesk> historyUserDesk = new ArrayList<UserDesk>();
      model.addAttribute("historyUserDesk",historyUserDesk);
    }
    try {
      List<UserGame> historyUserGame = userGameService.getAllUserGameByUserId(userId);
      List<UserGame> newHistoryUserGame = historyUserGame.subList(historyUserGame.size() - 2, historyUserGame.size());
      List<Game> historyGame = new ArrayList<Game>();
      for(UserGame userGame : newHistoryUserGame) {
        int gameId = userGame.getGameId();
        Game game = gameService.getGameById(gameId);
        historyGame.add(game);
      }
      model.addAttribute("historyGame",historyGame);
    }
    catch (Exception e) {
      List<Game> historyGame = new ArrayList<Game>();
      model.addAttribute("historyGame", historyGame);
    }

    return "html/mainPage";
  }

}
