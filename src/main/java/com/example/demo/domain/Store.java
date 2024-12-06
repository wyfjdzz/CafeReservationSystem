package com.example.demo.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "store")
@Entity
public class Store implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int storeId;

  private String storeAddresss;

  public int getStoreId() {return storeId;}
  public void setStoreId(int storeId) {this.storeId = storeId;}

  public String getStoreAddresss() {return storeAddresss;}
  public void setStoreAddresss(String storeAddresss) {this.storeAddresss = storeAddresss;}

}
