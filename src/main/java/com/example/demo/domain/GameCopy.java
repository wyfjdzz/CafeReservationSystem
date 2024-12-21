package com.example.demo.domain;

import com.example.demo.domain.PK.GameCopyPk;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Table(name = "gamecopy")
@Entity
@IdClass(GameCopyPk.class)
public class GameCopy {
  @Id
  private int gameCopyId;
  @Id
  private int gameId;
  private int storeId;
  private int gameCopyStatus;

  public int getGameCopyId() { return gameCopyId; }
  public void setGameCopyId(int gameCopyId) { this.gameCopyId = gameCopyId; }

  public int getGameId() { return gameId; }
  public void setGameId(int gameId) { this.gameId = gameId; }

  public int getStoreId() { return storeId; }
  public void setStoreId(int storeId) { this.storeId = storeId; }

  public int getGameCopyStatus() { return gameCopyStatus; }
  public void setGameCopyStatus(int gameCopyStatus) { this.gameCopyStatus = gameCopyStatus; }
}
