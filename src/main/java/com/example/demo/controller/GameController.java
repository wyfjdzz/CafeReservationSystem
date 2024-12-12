package com.example.demo.controller;

import com.example.demo.service.GameService;
import com.example.demo.domain.Game;
import com.example.demo.service.servicelmpl.GameServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

  @Autowired
  private GameServicelmpl gameService;

  @GetMapping("/gameAll")
  public String mainPageIframe(Model model) {
    List<Game> games = gameService.getAllGames();

    List<List<Game>> gameTable = new ArrayList<>();
    for (int i=0; i<games.size(); i+=3) {
      gameTable.add(games.subList(i, Math.min(i+3, games.size())));
    }

    model.addAttribute("gameTable", gameTable);

    return "html/GameAll";
  }
}
