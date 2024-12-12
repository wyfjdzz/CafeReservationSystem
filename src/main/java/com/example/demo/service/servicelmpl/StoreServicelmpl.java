package com.example.demo.service.servicelmpl;

import com.example.demo.domain.Store;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StoreService")
public class StoreServicelmpl implements StoreService {

  @Autowired
  private StoreMapper storeMapper;

  @Override
  public Store getStoreByStoreId(int storeId) {
    return storeMapper.getStoreByStoreId(storeId);
  }
  @Override
  public String getStoreNameByStoreId(int storeId) {
    return storeMapper.getStoreNameByStoreId(storeId);
  }
  @Override
  public int getStoreIdByStoreName(String storeName) {
    return storeMapper.getStoreIdByStoreName(storeName);
  }
  @Override
  public List<Integer> getAllDeskByStoreId(int storeId) {
    return storeMapper.getAllDeskByStoreId(storeId);
  }
  @Override
  public List<Integer> getAllStore() { return storeMapper.getAllStore(); }
  @Override
  public List<String> getAllStoreNames() { return storeMapper.getAllStoreNames(); }
}
