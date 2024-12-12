package com.example.demo.controller;

import com.example.demo.domain.Desk;
import com.example.demo.service.servicelmpl.DeskServicelmpl;
import com.example.demo.service.servicelmpl.StoreServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class DeskController {

  @Autowired
  private DeskServicelmpl deskService;
  @Autowired
  private StoreServicelmpl storeService;

  @RequestMapping("/deskOrder_SelectDesk")
  public String deskOrder_SelectDesk(Model model) {
    List<Map<String, String>> data = new ArrayList<>();
    List<Integer> allStoreIds = storeService.getAllStore();
    for (int storeId : allStoreIds) {
      List<Integer> allDesksInStore = storeService.getAllDeskByStoreId(storeId);
      for (int deskId : allDesksInStore) {
        Desk desk = deskService.getDeskByDeskId(deskId, storeId);
        Map<String, String> map = new LinkedHashMap<>();
//        map.put("store", String.valueOf(storeId));
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
    return "html/deskOrder_SelectDesk";
  }
}
