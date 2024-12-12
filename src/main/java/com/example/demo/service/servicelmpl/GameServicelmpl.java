package com.example.demo.service.servicelmpl;

import com.example.demo.domain.Game;
import com.example.demo.mapper.GameMapper;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GameService")
public class GameServicelmpl implements GameService {

  @Autowired
  private GameMapper gameMapper;

  @Override
  public Game getGameById(int id) {
    return gameMapper.getGameById(id);
  }

  @Override
  public Game getGameByName(String name) {
    return gameMapper.getGameByName(name);
  }

  @Override
  public List<Game> getAllGames() { return gameMapper.getAllGames(); }
}
