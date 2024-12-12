package com.example.demo.service;

import com.example.demo.domain.Store;

import java.util.List;

public interface StoreService {

  Store getStoreByStoreId(int storeId);

  String getStoreNameByStoreId(int storeId);

  int getStoreIdByStoreName(String storeName);

  List<Integer> getAllDeskByStoreId(int storeId);

  List<Integer> getAllStore();

  List<String> getAllStoreNames();
}
