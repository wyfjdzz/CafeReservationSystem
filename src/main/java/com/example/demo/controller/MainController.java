package com.example.demo.controller;

import com.example.demo.domain.Game;
import com.example.demo.domain.User;
import com.example.demo.domain.UserDesk;
import com.example.demo.domain.UserGame;
import com.example.demo.service.GameService;
import com.example.demo.service.UserDeskService;
import com.example.demo.service.UserGameService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

  @Autowired
  private UserDeskService userDeskService;
  @Autowired
  private UserGameService userGameService;
  @Autowired
  private GameService gameService;
  @Autowired
  private UserService userService;

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

    return "html/main/mainPage";
  }

  @GetMapping("/gameAll")
  public String mainPageIframe(Model model) {
    List<Game> games = gameService.getAllGames();

    List<List<Game>> gameTable = new ArrayList<>();
    for (int i=0; i<games.size(); i+=3) {
      gameTable.add(games.subList(i, Math.min(i+3, games.size())));
    }

    model.addAttribute("gameTable", gameTable);

    return "html/main/GameAll";
  }

}
