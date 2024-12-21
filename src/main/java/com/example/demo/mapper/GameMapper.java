package com.example.demo.mapper;

import com.example.demo.domain.Game;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GameMapper {

  @Select("SELECT * FROM cafe.game WHERE GameId = #{id}")
  Game getGameById(int id);

  @Select("SELECT * FROM cafe.game WHERE GameName = #{name}")
  Game getGameByName(String name);

  @Select("SELECT * FROM cafe.game")
  List<Game> getAllGames();

  @Select("SELECT GameId FROM  cafe.game")
  List<Integer> getAllGameIds();

  @Select("SELECT GameName FROM cafe.game WHERE GameId = #{gameId}")
  String getGameNameByGameId(int gameId);

  @Select("SELECT GameCategory FROM cafe.game WHERE GameId = #{gameId}")
  String getGameCategoryByGameId(int gameId);

  @Select("SELECT GameNumber FROM cafe.game WHERE GameId = #{gameId}")
  String getGameNumberByGameId(int gameId);

  @Select("SELECT GameImage FROM cafe.game WHERE GameId = #{gameId}")
  String getGameImageByGameId(int gameId);

  @Select("SELECT GameStatus FROM cafe.game WHERE GameId = #{gameId}")
  int getGameStatus(int gameId);

  @Update("UPDATE cafe.game SET GameStatus = #{status} WHERE GameId = #{gameId}")
  void updateGameStatus(int gameId, int status);

  @Update("UPDATE cafe.game SET GameName = #{gameName}, GameNumber = #{gameNumber}, "+
      "GameDescription = #{gameDescription}, GameDetails = #{gameDetails} WHERE GameId = #{gameId}")
  void updateGame(int gameId, String gameName, String gameNumber, String gameDescription, String gameDetails);

  @Insert("INSERT INTO cafe.game(GameId, GameName, GameImage, GameNumber, GameDescription, GameDetails, GameStatus)" +
      "values (#{gameId},#{gameName},#{gameImage},#{gameNumber},#{gameDescription},#{gameDetails},#{gameStatus})")
  void addGame(Game game);
}
