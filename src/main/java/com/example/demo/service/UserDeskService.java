package com.example.demo.service;

import com.example.demo.domain.UserDesk;

import java.util.List;

public interface UserDeskService {

  UserDesk getUserDeskById(int orderId);

  List<UserDesk> getAllUserDeskByUserId(int userId);

}
