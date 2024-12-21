package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameCopyMapper {

  @Select("SELECT StoreId FROM gamecopy WHERE GameId = #{gameId}")
  List<Integer> getStoreIdByGameId(int gameId);

  @Select("SELECT GameCopyId FROM gamecopy WHERE GameId = #{gameId}")
  List<Integer> getGameCopyIdByGameId(int gameId);

  @Select("SELECT GameId FROM gamecopy WHERE StoreId = #{storeId}")
  List<Integer> getGameIdByStoreId(int storeId);

  @Select("SELECT GameCopyStatus FROM cafe.gamecopy WHERE GameId = #{gameId} AND GameCopyId = #{gameCopyId}")
  int getGameStatus(int gameId, int gameCopyId);
}
