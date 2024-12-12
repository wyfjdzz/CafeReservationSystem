package com.example.demo.service.servicelmpl;

import com.example.demo.domain.UserGame;
import com.example.demo.mapper.UserGameMapper;
import com.example.demo.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserGameService")
public class UserGameServicelmpl implements UserGameService {

  @Autowired
  private UserGameMapper userGameMapper;

  @Override
  public UserGame getUserGameByObserveId(int observeId) {
    return userGameMapper.getUserGameByObserveId(observeId);
  }

  @Override
  public List<UserGame> getAllUserGameByUserId(int userId) {
    return userGameMapper.getAllUserGameByUserId(userId);
  }
}
