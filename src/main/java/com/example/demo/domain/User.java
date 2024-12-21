package com.example.demo.domain;

import jakarta.persistence.*;

@Table(name = "user")
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int userId;

  private String userPassword;
  private String userName;
  private int userSex;
  private String userTelephone;

  public int getuserId() {return userId;}
  public void setuserId(int userId) {this.userId = userId;}

  public String getuserPassword() {return userPassword;}
  public void setuserPassword(String userPassword) {this.userPassword = userPassword;}

  public String getuserName() {return userName;}
  public void setuserName(String userName) {this.userName = userName;}

  public int getuserSex() {return userSex;}
  public void setuserSex(int userSex) {this.userSex = userSex;}

  public String getuserTelephone() {return userTelephone;}
  public void setuserTelephone(String userTelephone) {this.userTelephone = userTelephone;}
}
