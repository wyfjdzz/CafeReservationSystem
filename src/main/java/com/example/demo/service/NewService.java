package com.example.demo.service;

import com.example.demo.domain.New;
import com.example.demo.mapper.NewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NewMapper")
public class NewService {
  @Autowired
  private NewMapper newMapper;

  public List<New> getAllNews() { return newMapper.getAllNews(); }

  public String getNewDescription(int newId) { return newMapper.getNewDescription(newId); }

  public String getNewDetail(int newId) { return newMapper.getNewDetail(newId); }

  public New getNewById(int newId) { return newMapper.getNewById(newId); }
}
