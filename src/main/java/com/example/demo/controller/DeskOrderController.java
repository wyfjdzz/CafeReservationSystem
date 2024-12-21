package com.example.demo.controller;

import com.example.demo.domain.Desk;
import com.example.demo.service.DeskService;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class DeskOrderController {

  @Autowired
  private DeskService deskService;
  @Autowired
  private StoreService storeService;

  @RequestMapping("/deskOrder_OrderSuccess")
  public String orderSuccess() { return "html/deskOrder/deskOrder_OrderSuccess"; }

  @RequestMapping("/deskOrder_SelectDesk")
  public String deskOrder_SelectDesk(Model model) {
    List<Map<String, String>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (int storeId : allStoreIds) {
      List<Integer> allDesksInStore = storeService.getAllDeskByStoreId(storeId);
      for (int deskId : allDesksInStore) {
        Desk desk = deskService.getDesk(deskId, storeId);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("store", storeService.getStoreNameByStoreId(storeId));
        map.put("id", String.valueOf(deskId));
        if (desk.getDeskCapacity() <= 2) {
          map.put("type", "1-2");
          map.put("price", "30");
        }
        else if (desk.getDeskCapacity() <= 6) {
          map.put("type", "3-6");
          map.put("price", "45");
        }
        else if (desk.getDeskCapacity() <= 12) {
          map.put("type", "7-12");
          map.put("price", "60");
        }
        data.add(map);
      }
    }
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("dataList", data);
    model.addAttribute("allStoreNames", allStoreNames);
    return "html/deskOrder/deskOrder_SelectDesk";
  }

  @RequestMapping("/deskOrder_SelectTime")
  public String deskOrderSelectTime(){
    return "html/deskOrder/deskOrder_SelectTime";
  }

  @RequestMapping("/deskOrder_FirstSelect")
  public String deskOrderFirstSelect(Model model){
    List<String> allStoreNames = storeService.getAllStoreNames();
    model.addAttribute("allStoreNames", allStoreNames);
    return "html/deskOrder/deskOrder_FirstSelect";
  }

  @RequestMapping("/deskOrder_OrderDetails")
  public String deskOrderOrderDetails(){ return "html/deskOrder/deskOrder_OrderDetails"; }
}
