package com.example.demo.controller;

import com.example.demo.domain.Desk;
import com.example.demo.domain.Game;
import com.example.demo.domain.User;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {
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
  @Autowired
  private DeskService deskService;

  @RequestMapping("/Manager_MainPage")
  public String ManagerMainPage() { return "html/Manager/MainPage"; }

  @RequestMapping("/Manager_GameManage_SelectManageType")
  public String SelectManageType() { return "html/Manager/GameManage/SelectManageType"; }

  @RequestMapping("/Manager_GameManage_Upload")
  public String Upload(Model model) {
    List<String> allTagNames = gameTagService.getAllTagsName();
    model.addAttribute("allTagNames", allTagNames);
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("allStoreNames", allStoreNames);
    return "html/Manager/GameManage/Upload";
  }

  @RequestMapping("/Manager_GameManage_UploadSuccess")
  public String UploadSuccess() { return "html/Manager/GameManage/UploadSuccess"; }

  @RequestMapping("/Manager_GameManage_Update")
  public String Update(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (Integer storeId : allStoreIds) {
      List<Integer> allGameInStore = gameCopyService.getGameIdByStoreId(storeId);
      for (Integer gameId : allGameInStore) {
        if (gameService.getGameStatus(gameId) != 1)
          continue;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", gameId);
        map.put("store", storeService.getStoreNameByStoreId(storeId));
        map.put("name", gameService.getGameNameByGameId(gameId));
        map.put("imageURL", gameService.getGameImageByGameId(gameId));
        map.put("recommendPeopleLeast", gameService.getGameNumberMinByGameId(gameId));
        map.put("recommendPeopleMost", gameService.getGameNumberMaxByGameId(gameId));
        map.put("type", gameTagService.getTagsByGameId(gameId));
        data.add(map);
      }
    }
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("allStoreNames", allStoreNames);
    model.addAttribute("dataList", data);
    List<String> allTagNames = gameTagService.getAllTagsName();
    model.addAttribute("allTagNames", allTagNames);
    return "html/Manager/GameManage/Update";
  }

  @RequestMapping("/Manager_GameManage_UpdateInfo")
  public String UpdateInfo(Model model) {
    List<String> allTagNames = gameTagService.getAllTagsName();
    model.addAttribute("allTagNames", allTagNames);
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("allStoreNames", allStoreNames);
    return "html/Manager/GameManage/UpdateInfo";
  }

  @RequestMapping("/Manager_GameManage_UpdateSuccess")
  public String UpdateSuccess(Model model) { return "html/Manager/GameManage/UpdateSuccess"; }

  @RequestMapping("/Manager_GameManage_Delete")
  public String Delete(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (Integer storeId : allStoreIds) {
      List<Integer> allGameInStore = gameCopyService.getGameIdByStoreId(storeId);
      for (Integer gameId : allGameInStore) {
        if (gameService.getGameStatus(gameId) != 1)
          continue;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", gameId);
        map.put("store", storeService.getStoreNameByStoreId(storeId));
        map.put("name", gameService.getGameNameByGameId(gameId));
        map.put("imageURL", gameService.getGameImageByGameId(gameId));
        map.put("recommendPeopleLeast", gameService.getGameNumberMinByGameId(gameId));
        map.put("recommendPeopleMost", gameService.getGameNumberMaxByGameId(gameId));
        map.put("type", gameTagService.getTagsByGameId(gameId));
        data.add(map);
      }
    }
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("allStoreNames", allStoreNames);
    model.addAttribute("dataList", data);
    List<String> allTagNames = gameTagService.getAllTagsName();
    model.addAttribute("allTagNames", allTagNames);
    return "html/Manager/GameManage/Delete";
  }

  @RequestMapping("/Manager_GameManage_DeleteSuccess")
  public String DeleteSuccess() { return "html/Manager/GameManage/DeleteSuccess"; }

  @PostMapping("Delete")
  public String delete(@ModelAttribute Game game) {
    gameService.updateGameStatus(game.getGameId(), 0);
    return "redirect:/Manager_GameManage_DeleteSuccess";
  }

  @RequestMapping("/Manager_UserAll")
  public String UserAll(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allUserIds = userService.getAllUserId();
    for (int userId : allUserIds) {
      User user = userService.findUserById(userId);
      Map<String, Object> map = new LinkedHashMap<>();
      map.put("UserId", user.getuserId());
      map.put("UserPassword", user.getuserPassword());
      map.put("UserName", user.getuserName());
      if(user.getuserSex()==1)
        map.put("UserSex", "女");
      else
        map.put("UserSex", "男");
      map.put("UserTelephone", user.getuserTelephone());
      data.add(map);
    }
    model.addAttribute("dataList", data);
    return "html/Manager/UserAll";
  }

  @RequestMapping("Manager_DeskManage_Delete")
  public String DeleteDesk(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (int storeId : allStoreIds) {
      List<Integer> allDeskInStore = deskService.getAllDeskInStore(storeId);
      for (int deskId : allDeskInStore) {
        Desk desk = deskService.getDesk(deskId, storeId);
        if (desk.getDeskStatus() != 1)
          continue;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("StoreId", storeService.getStoreNameByStoreId(storeId));
        map.put("DeskId", desk.getDeskId());
        map.put("DeskCapacity", String.valueOf(desk.getDeskCapacity()));
        if (desk.getDeskCapacity() <= 2)        map.put("price", "30");
        else if (desk.getDeskCapacity() <= 6)   map.put("price", "45");
        else if (desk.getDeskCapacity() <= 12)  map.put("price", "60");
        data.add(map);
      }
    }
    model.addAttribute("dataList", data);
    List<String> storeNames = storeService.getAllStoreNames();
    model.addAttribute("storeOptions", storeNames);
    return "html/Manager/DeskManage/Delete";
  }

  @RequestMapping("/Manager_DeskManage_DeleteSuccess")
  public String DeleteDeskSuccess() { return "html/Manager/DeskManage/DeleteSuccess"; }

  @PostMapping("DeskDelete")
  public String deskDelete(@ModelAttribute Desk desk) {
    deskService.updateDeskStatus(desk.getDeskId(), 0);
    return "redirect:/Manager_DeskManage_DeleteSuccess";
  }

  @RequestMapping("/Manager_DeskManage_SelectManageType")
  public String SelectDeskType() { return "html/Manager/DeskManage/SelectManageType"; }

  @RequestMapping("/Manager_DeskManage_Update")
  public String UpdateDesk(Model model) {
    List<Map<String, Object>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (int storeId : allStoreIds) {
      List<Integer> allDeskInStore = deskService.getAllDeskInStore(storeId);
      for (int deskId : allDeskInStore) {
        Desk desk = deskService.getDesk(deskId, storeId);
        if (desk.getDeskStatus() != 1)
          continue;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("StoreId", storeService.getStoreNameByStoreId(storeId));
        map.put("DeskId", desk.getDeskId());
        map.put("DeskCapacity", String.valueOf(desk.getDeskCapacity()));
        if (desk.getDeskCapacity() <= 2)        map.put("price", "30");
        else if (desk.getDeskCapacity() <= 6)   map.put("price", "45");
        else if (desk.getDeskCapacity() <= 12)  map.put("price", "60");
        data.add(map);
      }
    }
    model.addAttribute("dataList", data);
    List<String> storeNames = storeService.getAllStoreNames();
    model.addAttribute("storeOptions", storeNames);
    return "html/Manager/DeskManage/Update";
  }

  @RequestMapping("/Manager_DeskManage_UpdateInfo")
  public String UpdateDeskInfo(Model model) {
    model.addAttribute("allStoreNames",storeService.getAllStoreNames());
    return "html/Manager/DeskManage/UpdateInfo";
  }

  @RequestMapping("/Manager_DeskManage_UpdateSuccess")
  public String UpdateDeskSuccess() { return "html/Manager/DeskManage/UpdateSuccess"; }

  @RequestMapping("/Manager_DeskManage_Upload")
  public String UploadDesk(Model model) {
    model.addAttribute("allStoreNames",storeService.getAllStoreNames());
    return "html/Manager/DeskManage/Upload";
  }

  @RequestMapping("Manager_DeskManage_UploadSuccess")
  public String UploadDeskSuccess() { return "html/Manager/DeskManage/UploadSuccess"; }

  @RequestMapping("/Manager_OrderManage_SelectOrderType")
  public String SelectOrderType() { return "html/Manager/OrderManage_SelectOrderType"; }



}
