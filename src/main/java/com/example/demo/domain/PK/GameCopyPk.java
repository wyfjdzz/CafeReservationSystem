package com.example.demo.domain.PK;

import java.io.Serializable;
import java.util.Objects;

public class GameCopyPk implements Serializable {
  private int gameCopyId;
  private int gameId;
  public GameCopyPk() {}
  public GameCopyPk(int gameCopyId, int gameId) {
    this.gameCopyId = gameCopyId;
    this.gameId = gameId;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameCopyPk gameCopyPk = (GameCopyPk) o;
    return gameCopyId == gameCopyPk.gameCopyId && gameId == gameCopyPk.gameId;
  }
  @Override
  public int hashCode() { return Objects.hash(gameCopyId,gameId); }

  public int getGameCopyId() { return gameCopyId; }
  public void setGameCopyId(int gameCopyId) { this.gameCopyId = gameCopyId; }

  public int getGameId() { return gameId; }
  public void setGameId(int gameId) { this.gameId = gameId; }

}
