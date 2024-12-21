package com.example.demo.controller;

import com.example.demo.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeskGameController {
  @Autowired
  private GameService gameService;
  @Autowired
  private StoreService storeService;
  @Autowired
  private GameCopyService gameCopyService;
  @Autowired
  private GameTagService gameTagService;
  @Autowired
  private UserService userService;

  @RequestMapping("/deskGame_All")
  public String deskGameAll(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (Integer storeId : allStoreIds) {
      List<Integer> allGameInStore = gameCopyService.getGameIdByStoreId(storeId);
      for (Integer gameId : allGameInStore) {
        if (gameService.getGameStatus(gameId) != 1)
          continue;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("store", storeService.getStoreNameByStoreId(storeId));
        map.put("name", gameService.getGameNameByGameId(gameId));
        map.put("imageURL", gameService.getGameImageByGameId(gameId));
        map.put("recommendPeopleLeast", gameService.getGameNumberMinByGameId(gameId));
        map.put("recommendPeopleMost", gameService.getGameNumberMaxByGameId(gameId));
        map.put("type", gameTagService.getTagsByGameId(gameId));
        data.add(map);
      }
    }
    model.addAttribute("dataList", data);
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("allStoreNames", allStoreNames);
    List<String> allTagNames = gameTagService.getAllTagsName();
    model.addAttribute("allTagNames", allTagNames);
    return "html/deskGame/deskGame_All";
  }

  @RequestMapping("/deskGame_Detail")
  public String deskGameDetail() {
    return "html/deskGame/deskGame_Detail";
  }

  @RequestMapping("/deskGame_Reserve")
  public String deskGameReserve(HttpSession session, Model model) {
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
      return "redirect:/login";
    }
    String userName = userService.getUserNameByUserId(userId);
    model.addAttribute("userName", userName);
    return "html/deskGame/deskGame_Reserve";
  }

  @RequestMapping("/deskGame_OrderSuccess")
  public String deskGameOrderSuccess() { return "html/deskGame/deskGame_OrderSuccess"; }
}
