package com.example.demo.service;

import com.example.demo.domain.Game;

import java.util.List;

public interface GameService {

  Game getGameById(int id);

  Game getGameByName(String name);

  List<Game> getAllGames();
}
