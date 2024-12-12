package com.example.demo.service.servicelmpl;

import com.example.demo.domain.Desk;
import com.example.demo.mapper.DeskMapper;
import com.example.demo.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DeskService")
public class DeskServicelmpl implements DeskService {

  @Autowired
  private DeskMapper deskMapper;

  @Override
  public Desk getDeskByDeskId(int deskId, int storeId) {
    return deskMapper.getDeskByDeskId(deskId, storeId);
  }

  @Override
  public List<Desk> getDeskByStoreId(int storeId) {
    return deskMapper.getDeskByStoreId(storeId);
  }
}
