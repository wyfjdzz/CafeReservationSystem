package com.example.demo.service;

import com.example.demo.domain.UserDesk;

public interface OrderService {
  //添加用户预约
  int addOrder(UserDesk userDesk);
  //查看预约信息
  UserDesk getUserDesk(int UserID);
}
