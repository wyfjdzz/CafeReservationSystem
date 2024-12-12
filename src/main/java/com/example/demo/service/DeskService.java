package com.example.demo.service;

import com.example.demo.domain.Desk;

import java.util.List;

public interface DeskService {

  Desk getDeskByDeskId(int deskId, int storeId);

  List<Desk> getDeskByStoreId(int storeId);
}
