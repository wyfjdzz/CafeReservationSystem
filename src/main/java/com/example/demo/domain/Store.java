package com.example.demo.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "store")
@Entity
public class Store implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int storeId;
  private String storeName;
  private String storeAddress;

  public int getStoreId() {return storeId;}
  public void setStoreId(int storeId) {this.storeId = storeId;}

  public String getStoreName() {return storeName;}
  public void setStoreName(String storeName) {this.storeName = storeName;}

  public String getStoreAddress() {return storeAddress;}
  public void setStoreAddress(String storeAddress) {this.storeAddress = storeAddress;}

}
