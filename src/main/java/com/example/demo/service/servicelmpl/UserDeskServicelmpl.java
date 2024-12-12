package com.example.demo.service.servicelmpl;

import com.example.demo.domain.UserDesk;
import com.example.demo.mapper.UserDeskMapper;
import com.example.demo.service.UserDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserDeskService")
public class UserDeskServicelmpl implements UserDeskService {

  @Autowired
  private UserDeskMapper userDeskMapper;

  @Override
  public UserDesk getUserDeskById(int id) {
    return userDeskMapper.getUserDeskById(id);
  }

  @Override
  public List<UserDesk> getAllUserDeskByUserId(int userId) {
    return userDeskMapper.getAllUserDeskByUserId(userId);
  }
}
