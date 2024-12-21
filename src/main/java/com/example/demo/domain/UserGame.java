package com.example.demo.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "user_game")
@Entity
public class UserGame {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int observeId;
  private int userId;
  private int gameCopyId;
  private int gameId;
  private Timestamp startTime;
  private Timestamp endTime;
  private int observeStatus;

  public int getObserveId() {return observeId;}
  public void setObserveId(int observeId) {this.observeId = observeId;}

  public int getUserId() {return userId;}
  public void setUserId(int userId) {this.userId = userId;}

  public int getGameCopyId() {return gameCopyId;}
  public void setGameCopyId(int gameCopyId) {this.gameCopyId = gameCopyId;}

  public int getGameId() {return gameId;}
  public void setGameId(int gameId) {this.gameId = gameId;}

  public Timestamp getStartTime() {return startTime;}
  public void setStartTime(Timestamp startTime) {this.startTime = startTime;}

  public Timestamp getEndTime() {return endTime;}
  public void setEndTime(Timestamp endTime) {this.endTime = endTime;}

  public int getObserveStatus() {return observeStatus;}
  public void setObserveStatus(int observeStatus) {this.observeStatus = observeStatus;}

}
