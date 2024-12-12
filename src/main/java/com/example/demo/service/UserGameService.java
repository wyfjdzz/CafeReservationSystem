package com.example.demo.service;

import com.example.demo.domain.UserGame;

import java.util.List;

public interface UserGameService {

  UserGame getUserGameByObserveId(int observeId);

  List<UserGame> getAllUserGameByUserId(int userId);
}
