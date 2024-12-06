package com.example.demo.service.servicelmpl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServicelmpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User findUserById(int id) {
    return userMapper.findUserById(id);
  }

  @Override
  public User findUserByName(String name) {
    return userMapper.findUserByName(name);
  }

  @Override
  public int addUser(User user) {
    return userMapper.addUser(user);
  }

  @Override
  public int login(String username, String password) {
    User user = userMapper.findUserByName(username);
    if (user.getuserPassword().equals(password)) {
      return user.getuserId();
    } else {
      return 0;
    }
  }
}
