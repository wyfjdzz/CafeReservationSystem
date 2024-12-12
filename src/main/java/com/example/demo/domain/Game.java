package com.example.demo.domain;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "game")
@Entity
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int observeId;
  private String gameName;
  private String gameCategory;
  private String gameImage;
  private String gameNumber;

  public int getObserveId() {return observeId;}
  public void setObserveId(int observeId) {this.observeId = observeId;}

  public String getGameName() {return gameName;}
  public void setGameName(String gameName) {this.gameName = gameName;}

  public String getGameCategory() {return gameCategory;}
  public void setGameCategory(String gameCategory) {this.gameCategory = gameCategory;}

  public String getGameImage() {return gameImage;}
  public void setGameImage(String gameImage) {this.gameImage = gameImage;}

  public String getGameNumber() {return gameNumber;}
  public void setGameNumber(String gameNumber) {this.gameNumber = gameNumber;}
}
