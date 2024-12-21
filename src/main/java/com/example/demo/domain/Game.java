package com.example.demo.domain;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "game")
@Entity
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int gameId;
  private String gameName;
  private String gameImage;
  private String gameNumber;
  private String gameDescription;
  private String gameDetails;
  private String gameStatus;

  public int getGameId() { return this.gameId; }
  public void setGameId(int gameId) { this.gameId = gameId; }

  public String getGameName() {return gameName;}
  public void setGameName(String gameName) {this.gameName = gameName;}

  public String getGameImage() {return gameImage;}
  public void setGameImage(String gameImage) {this.gameImage = gameImage;}

  public String getGameNumber() {return gameNumber;}
  public void setGameNumber(String gameNumber) {this.gameNumber = gameNumber;}

  public String getGameDescription() {return gameDescription;}
  public void setGameDescription(String gameDescription) {this.gameDescription = gameDescription;}

  public String getGameDetails() {return gameDetails;}
  public void setGameDetails(String gameDetails) {this.gameDetails = gameDetails;}

  public String getGameStatus() {return gameStatus;}
  public void setGameStatus(String gameStatus) {this.gameStatus = gameStatus;}
}
