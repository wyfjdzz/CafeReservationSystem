package com.example.demo.controller;

import com.example.demo.domain.Desk;
import com.example.demo.domain.Game;
import com.example.demo.domain.New;
import com.example.demo.domain.UserDesk;
import com.example.demo.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Objects;

@RestController
public class PostController {

  @Autowired
  private GameService gameService;
  @Autowired
  private StoreService storeService;
  @Autowired
  private OrderService orderService;
  @Autowired
  private NewService newService;
  @Autowired
  private GameTagService gameTagService;
  @Autowired
  private DeskService deskService;

  @PostMapping("/Detail")
  @ResponseBody
  public Game deskGameDetail(@RequestBody Game g) {
    return gameService.getGameByName(g.getGameName());
  }

  @PostMapping("/SelectTime")
  @ResponseBody
  public List<UserDesk> selectTime(@RequestParam("deskId") int deskId,
                         @RequestParam("storeName") String storeName,
                         @RequestParam("price") int price,
                         @RequestParam("startTime") List<Integer> startTimes,
                         HttpSession session) {
    List<UserDesk> userDesks = new ArrayList<>();
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
      System.out.println("请先登录");
      return null;
    }
    LocalDateTime now = LocalDateTime.now();
    for (Integer startTime : startTimes) {
      LocalDateTime targetTime = now.withHour(startTime).withMinute(0).withSecond(0).withNano(0);
      Timestamp timestamp = Timestamp.valueOf(targetTime);
      UserDesk userDesk = new UserDesk();
      userDesk.setUserId(userId);
      userDesk.setDeskId(deskId);
      userDesk.setStoreId(storeService.getStoreIdByStoreName(storeName));
      userDesk.setPrice(price);
      userDesk.setStartTime(timestamp);
      userDesk.setOrderStatus(0);
      orderService.addOrder(userDesk);
      userDesks.add(userDesk);
    }
    return userDesks;
  }

  @PostMapping("/NewDetail")
  @ResponseBody
  public New NewDetail(@RequestBody New news) { return newService.getNewById(news.getNewId()); }

  @PostMapping("/UpdateSuccess")
  @ResponseBody
  public void UpdateSuccess(@RequestParam("gameName") String gameName,
                            @RequestParam("storeName") String storeName,
                            @RequestParam("peopleLeast") String peopleLeast,
                            @RequestParam("peopleMost") String peopleMost,
                            @RequestParam("type1") String type1,
                            @RequestParam("type2") String type2,
                            @RequestParam("type3") String type3,
                            @RequestParam("gameDescription") String gameDescription,
                            @RequestParam("gameDetails") String gameDetails) {
    int gameId = gameService.getGameByName(gameName).getGameId();
    int storeId = storeService.getStoreIdByStoreName(storeName);
    String gameNumber = peopleLeast + "-" + peopleMost;
    gameService.updateGame(gameId, gameName, gameNumber, gameDescription, gameDetails);
    if (!Objects.equals(type1, "null"))
      gameTagService.insertGameTag(gameId, type1);
    if (!Objects.equals(type2, "null"))
      gameTagService.insertGameTag(gameId, type2);
    if (!Objects.equals(type3, "null"))
      gameTagService.insertGameTag(gameId, type3);
  }

  @PostMapping("/UploadSuccess")
  @ResponseBody
  public void UploadSuccess(@RequestParam("gameName") String gameName,
                            @RequestParam("storeName") String storeName,
                            @RequestParam("peopleLeast") String peopleLeast,
                            @RequestParam("peopleMost") String peopleMost,
                            @RequestParam("type1") String type1,
                            @RequestParam("type2") String type2,
                            @RequestParam("type3") String type3,
                            @RequestParam("gameDescription") String gameDescription,
                            @RequestParam("gameDetails") String gameDetails) {
    String gameNumber = peopleLeast + "-" + peopleMost;
    Game game = new Game();
    game.setGameName(gameName);
    game.setGameNumber(gameNumber);
    game.setGameDescription(gameDescription);
    game.setGameDetails(gameDetails);
    game.setGameStatus("1");
    gameService.addGame(game);
    int gameId = gameService.getGameByName(gameName).getGameId();
    if (!Objects.equals(type1, "null"))
      gameTagService.insertGameTag(gameId, type1);
    if (!Objects.equals(type2, "null"))
      gameTagService.insertGameTag(gameId, type2);
    if (!Objects.equals(type3, "null"))
      gameTagService.insertGameTag(gameId, type3);
  }

  @PostMapping("/UpdateDeskSuccess")
  @ResponseBody
  public void UpdateDeskSuccess(@RequestParam("storeName") String storeName,
                                @RequestParam("deskCapacity") String deskCapacity){
    Desk desk = deskService.getDesk(1, storeService.getStoreIdByStoreName(storeName));
    desk.setDeskCapacity(Integer.parseInt(deskCapacity));
    deskService.updateDesk(desk);
  }

  @PostMapping("/UploadDeskSuccess")
  @ResponseBody
  public void UploadDeskSuccess(@RequestParam("storeName") String storeName,
                                @RequestParam("deskCapacity") String deskCapacity){
    List<Integer> allDeskIds = deskService.getAllDeskInStore(storeService.getStoreIdByStoreName(storeName));
    Desk desk = new Desk();
    desk.setDeskId(allDeskIds.get(allDeskIds.size() - 1) + 1);
    desk.setStoreId(storeService.getStoreIdByStoreName(storeName));
    desk.setDeskCapacity(Integer.parseInt(deskCapacity));
    desk.setDeskStatus(1);
    deskService.uploadDesk(desk);
  }
}
