package com.example.demo.domain;

import com.example.demo.domain.PK.DeskPk;
import jakarta.persistence.*;

@Table(name = "desk")
@Entity
@IdClass(DeskPk.class)
public class Desk {
  @Id
  private int deskId;
  @Id
  private int storeId;
  private int deskCapacity;
  private int deskStatus;

  public int getDeskId() {return deskId;}
  public void setDeskId(int deskId) {this.deskId = deskId;}

  public int getStoreId() {return storeId;}
  public void setStoreId(int storeId) {this.storeId = storeId;}

  public int getDeskCapacity() {return deskCapacity;}
  public void setDeskCapacity(int deskCapacity) {this.deskCapacity = deskCapacity;}

  public int getDeskStatus() {return deskStatus;}
  public void setDeskStatus(int deskStatus) {this.deskStatus = deskStatus;}
}
