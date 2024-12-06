package com.example.demo.domain.PK;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


public class DeskPk implements Serializable {
  private int deskId;
  private int storeId;
  public DeskPk() {}
  public DeskPk(int deskId, int storeId) {
    this.deskId = deskId;
    this.storeId = storeId;
  }
  // 覆盖 equals方法
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeskPk deskPk = (DeskPk) o;
    return deskId == deskPk.deskId && storeId == deskPk.storeId;
  }
  // 覆盖 hashCode方法
  @Override
  public int hashCode() {
    return Objects.hash(deskId,storeId);
  }

  public int getDeskId() {return deskId;}
  public void setDeskId(int deskId) {this.deskId = deskId;}

  public int getStoreId() {return storeId;}
  public void setStoreId(int storeId) {this.storeId = storeId;}
}
