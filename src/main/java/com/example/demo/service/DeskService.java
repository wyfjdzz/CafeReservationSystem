package com.example.demo.service;

import com.example.demo.domain.Desk;
import com.example.demo.mapper.DeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DeskService")
public class DeskService{

  @Autowired
  private DeskMapper deskMapper;

  public Desk getDesk(int deskId, int storeId) {
    return deskMapper.getDesk(deskId, storeId);
  }

  public List<Desk> getDeskByStoreId(int storeId) {
    return deskMapper.getDeskByStoreId(storeId);
  }

  public List<Integer> getAllDeskInStore(int storeId) { return deskMapper.getAllDeskInStore(storeId); }

  public void updateDeskStatus(int deskId, int deskStatus) { deskMapper.updateDeskStatus(deskId, deskStatus); }

  public void updateDesk(Desk desk) { deskMapper.updateDesk(desk); }

  public void uploadDesk(Desk desk) { deskMapper.uploadDesk(desk); }
}
