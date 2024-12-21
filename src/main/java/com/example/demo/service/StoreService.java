package com.example.demo.service;

import com.example.demo.domain.Store;
import com.example.demo.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StoreService")
public class StoreService{

  @Autowired
  private StoreMapper storeMapper;


  public Store getStoreByStoreId(int storeId) {
    return storeMapper.getStoreByStoreId(storeId);
  }

  public String getStoreNameByStoreId(int storeId) {
    return storeMapper.getStoreNameByStoreId(storeId);
  }

  public int getStoreIdByStoreName(String storeName) {
    return storeMapper.getStoreIdByStoreName(storeName);
  }

  public List<Integer> getAllDeskByStoreId(int storeId) {
    return storeMapper.getAllDeskByStoreId(storeId);
  }

  public List<Integer> getAllStore() { return storeMapper.getAllStore(); }

  public List<String> getAllStoreNames() { return storeMapper.getAllStoreNames(); }
}
