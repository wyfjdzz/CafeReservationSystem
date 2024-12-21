package com.example.demo.controller;

import com.example.demo.domain.UserDesk;
import com.example.demo.domain.UserGame;
import com.example.demo.service.DeskService;
import com.example.demo.service.GameService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserHomeController {

  @Autowired
  private OrderService orderService;
  @Autowired
  private UserService userService;
  @Autowired
  private GameService gameService;

  @RequestMapping("/UserHome_MainPage")
  public String MainPage() {
    return "html/UserHome/MainPage";
  }

  @RequestMapping("/UserHome_DeskReserveRecord")
  public String DeskReserveRecord(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allOrderIds = orderService.findAllOrderId();
    for (Integer orderId : allOrderIds) {
      Map<String, Object> map = new HashMap<>();
      UserDesk userDesk = orderService.findUserDeskById(orderId);
      map.put("ObserveId", userDesk.getOrderId());
      map.put("UserName", userService.getUserNameByUserId(userDesk.getUserId()));
      map.put("DeskID", userDesk.getDeskId());
      map.put("ObserveDate", orderService.getObserveDate(userDesk.getStartTime()));
      map.put("StartTime", orderService.getObserveTime(userDesk.getStartTime()));
      map.put("EndTime", orderService.getObserveTime(userDesk.getEndTime()));
      map.put("ObserveStatus", String.valueOf(userDesk.getOrderStatus()));
      data.add(map);
    }
    model.addAttribute("dataList", data);
    return "html/UserHome/DeskReserveRecord";
  }

  @RequestMapping("/UserHome_GameReserveRecord")
  public String GameReserveRecord(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allObserveIds = orderService.findAllObserveId();
    for (Integer observeId : allObserveIds) {
      Map<String, Object> map = new HashMap<>();
      UserGame userGame = orderService.findUserGameByUserId(observeId);
      map.put("ObserveId", userGame.getObserveId());
      map.put("UserName", userService.getUserNameByUserId(userGame.getUserId()));
      map.put("GameName", gameService.getGameNameByGameId(userGame.getGameId()));
      map.put("ObserveDate", orderService.getObserveDate(userGame.getStartTime()));
      map.put("StartTime", orderService.getObserveTime(userGame.getStartTime()));
      map.put("EndTime", orderService.getObserveTime(userGame.getEndTime()));
      map.put("ObserveStatus", String.valueOf(userGame.getObserveStatus()));
      data.add(map);
    }
    model.addAttribute("dataList", data);
    return "html/UserHome/GameReserveRecord";
  }
}
