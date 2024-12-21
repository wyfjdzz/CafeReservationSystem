package com.example.demo.service;

import com.example.demo.domain.Game;
import com.example.demo.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GameService")
public class GameService{

  @Autowired
  private GameMapper gameMapper;

  public Game getGameById(int id) {
    return gameMapper.getGameById(id);
  }

  public Game getGameByName(String name) {
    return gameMapper.getGameByName(name);
  }

  public List<Game> getAllGames() { return gameMapper.getAllGames(); }

  public List<Integer> getAllGameIds() { return gameMapper.getAllGameIds(); }

  public String getGameNameByGameId(int gameId) { return gameMapper.getGameNameByGameId(gameId); }

  public String getGameCategoryByGameId(int gameId) { return gameMapper.getGameCategoryByGameId(gameId); }

  public String getGameImageByGameId(int gameId) { return gameMapper.getGameImageByGameId(gameId); }

  public String getGameNumberMinByGameId(int gameId) {
    String gameNumber = gameMapper.getGameNumberByGameId(gameId);
    String[] number = gameNumber.split("-");
    return number[0];
  }

  public String getGameNumberMaxByGameId(int gameId) {
    String gameNumber = gameMapper.getGameNumberByGameId(gameId);
    String[] number = gameNumber.split("-");
    return number[1];
  }

  public int getGameStatus(int gameId) { return gameMapper.getGameStatus(gameId); }

  public void updateGameStatus(int gameId, int status) { gameMapper.updateGameStatus(gameId, status); }

  public void updateGame(int gameId, String gameName, String gameNumber, String gameDescription, String gameDetails) {
    gameMapper.updateGame(gameId, gameName, gameNumber, gameDescription, gameDetails);
  }

  public void addGame(Game game) { gameMapper.addGame(game); }
}
