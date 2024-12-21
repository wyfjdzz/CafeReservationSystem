package com.example.demo.service;

import com.example.demo.mapper.GameTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GameTagService")
public class GameTagService {

  @Autowired
  private GameTagMapper gameTagMapper;

  public List<String> getTagsByGameId(int gameId) { return gameTagMapper.getTagsByGameId(gameId); }

  public List<String> getAllTagsName() { return gameTagMapper.getAllTagsName(); }

  public void insertGameTag(int gameId, String tagName) { gameTagMapper.insertGameTag(gameId, tagName); }
}
