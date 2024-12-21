package com.example.demo.service;

import com.example.demo.mapper.GameCopyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GameCopyService")
public class GameCopyService {
  @Autowired
  private GameCopyMapper gameCopyMapper;

  public List<Integer> getStoreIdByGameId(int gameId) { return gameCopyMapper.getStoreIdByGameId(gameId); }

  public List<Integer> getGameCopyIdByGameId(int gameId) { return gameCopyMapper.getGameCopyIdByGameId(gameId); }

  public List<Integer> getGameIdByStoreId(int storeId) { return gameCopyMapper.getGameIdByStoreId(storeId); }

  public int getGameStatus(int gameId, int gameCopyId) {
    return gameCopyMapper.getGameStatus(gameId, gameCopyId);
  }
}
