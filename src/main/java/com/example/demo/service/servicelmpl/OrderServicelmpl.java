package com.example.demo.service.servicelmpl;

import com.example.demo.domain.UserDesk;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServicelmpl implements OrderService {

  @Autowired
  private OrderMapper orderMapper;

  @Override
  public int addOrder(UserDesk userDesk) {
    return orderMapper.addOrder(userDesk);
  }
  @Override
  public UserDesk getUserDesk(int userId) {
    return orderMapper.findUserDeskByUserId(userId);
  }
}
