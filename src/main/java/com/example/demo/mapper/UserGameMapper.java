package com.example.demo.mapper;

import com.example.demo.domain.UserGame;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserGameMapper {

  @Select("SELECT * FROM cafe.user_game WHERE ObserveId = #{observeId}")
  UserGame getUserGameByObserveId(int observeId);

  @Select("SELECT * FROM cafe.user_game WHERE UserId = #{userId}")
  List<UserGame> getAllUserGameByUserId(int userId);

  @Insert("INSERT INTO cafe.user_game(ObserveId, UserId, GameCopyId, GameId, StartTime, EndTime, ObserveStatus)"+
          "values (#{observeId}, #{userId}, #{gameCopyId}, #{gameId}, NOW(), DATE_ADD(NOW(),INTERVAL 1 HOUR), #{observeStatus})")
  void addUserGame(UserGame userGame);
}
