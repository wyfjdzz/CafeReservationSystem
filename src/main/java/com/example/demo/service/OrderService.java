package com.example.demo.service;

import com.example.demo.domain.UserDesk;
import com.example.demo.domain.UserGame;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service("OrderService")
public class OrderService {

  @Autowired
  private OrderMapper orderMapper;

  public void addOrder(UserDesk userDesk) {
    orderMapper.addOrder(userDesk);
  }

  public List<Integer> findAllOrderId() { return orderMapper.findAllOrderId(); }

  public List<Integer> findAllObserveId() { return orderMapper.findAllObserveId(); }

  public UserGame findUserGameByUserId(int observeId) { return orderMapper.findUserGameById(observeId); }

  public UserDesk findUserDeskById(int orderId) {
    return orderMapper.findUserDeskById(orderId);
  }

  public String getObserveDate(Timestamp startTime) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(startTime);
  }

  public String getObserveTime(Timestamp startTime) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    return dateFormat.format(startTime);
  }
}
