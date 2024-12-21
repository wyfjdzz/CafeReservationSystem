package com.example.demo.service;

import com.example.demo.domain.UserDesk;
import com.example.demo.mapper.UserDeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserDeskService")
public class UserDeskService{

  @Autowired
  private UserDeskMapper userDeskMapper;

  public UserDesk getUserDeskById(int id) {
    return userDeskMapper.getUserDeskById(id);
  }

  public List<UserDesk> getAllUserDeskByUserId(int userId) {
    return userDeskMapper.getAllUserDeskByUserId(userId);
  }
}
