package com.example.demo.mapper;

import com.example.demo.domain.Game;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameMapper {

  @Select("SELECT * FROM cafe.game WHERE GameId = #{id}")
  Game getGameById(int id);

  @Select("SELECT * FROM cafe.game WHERE GameName = #{name}")
  Game getGameByName(String name);

  @Select("SELECT * FROM cafe.game")
  List<Game> getAllGames();
}
