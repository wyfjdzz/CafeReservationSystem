package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService{

  @Autowired
  private UserMapper userMapper;

  public User findUserById(int id) {
    return userMapper.findUserById(id);
  }

  public User findUserByName(String name) {
    return userMapper.findUserByName(name);
  }

  public void addUser(User user) {
    userMapper.addUser(user);
  }

  public int login(String username, String password) {
    User user = userMapper.findUserByName(username);
    if (user.getuserPassword().equals(password)) {
      return user.getuserId();
    } else {
      return 0;
    }
  }

  public String getUserNameByUserId(int userId) { return userMapper.getUserNameByUserId(userId); }

  public List<Integer> getAllUserId() { return userMapper.getAllUserId(); }
}
