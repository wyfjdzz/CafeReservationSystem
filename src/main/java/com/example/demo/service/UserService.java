package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {

  User findUserById(int id);

  User findUserByName(String username);

  int addUser(User user);

  int login(String username, String password);
}
