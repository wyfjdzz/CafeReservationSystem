package com.example.demo.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Table(name = "user_desk")
@Entity
public class UserDesk {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderId;
  private int userId;
  private int deskId;
  private int storeId;
  private Timestamp startTime;
  private Timestamp endTime;
  private int price;
  private int orderStatus;

  public int getId() {return orderId;}
  public void setId(int id) {this.orderId = orderId;}

  public int getUserId() {return userId;}
  public void setUserId(int userId) {this.userId = userId;}

  public int getDeskId() {return deskId;}
  public void setDeskId(int deskId) {this.deskId = deskId;}

  public int getStoreId() {return storeId;}
  public void setStoreId(int storeId) {this.storeId = storeId;}

  public Timestamp getStartTime() {return startTime;}
  public void setStartTime(Timestamp startTime) {this.startTime = startTime;}

  public Timestamp getEndTime() {return endTime;}
  public void setEndTime(Timestamp endTime) {this.endTime = endTime;}

  public int getPrice() {return price;}
  public void setPrice(int price) {this.price = price;}

  public int getorderStatus() {return orderStatus;}
  public void setorderStatus(int orderStatus) {this.orderStatus = orderStatus;}
}
