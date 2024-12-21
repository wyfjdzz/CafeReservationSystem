package com.example.demo.service;

import com.example.demo.domain.UserGame;
import com.example.demo.mapper.UserGameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserGameService")
public class UserGameService{

  @Autowired
  private UserGameMapper userGameMapper;

  public UserGame getUserGameByObserveId(int observeId) {
    return userGameMapper.getUserGameByObserveId(observeId);
  }

  public List<UserGame> getAllUserGameByUserId(int userId) {
    return userGameMapper.getAllUserGameByUserId(userId);
  }

  void addUserGame(UserGame userGame) { userGameMapper.addUserGame(userGame); }
}
