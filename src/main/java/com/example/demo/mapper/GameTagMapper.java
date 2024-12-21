package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameTagMapper {

  @Select("SELECT tagName FROM cafe.gametag WHERE GameId = #{gameId}")
  List<String> getTagsByGameId(int gameId);

  @Select("SELECT tagName FROM cafe.tag")
  List<String> getAllTagsName();

  @Insert("INSERT INTO cafe.gametag(GameId, tagName) VALUE (#{gameId}, #{tagName})")
  void insertGameTag(int gameId, String tagName);
}
