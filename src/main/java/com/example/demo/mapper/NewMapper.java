package com.example.demo.mapper;

import com.example.demo.domain.New;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewMapper {

  @Select("SELECT * FROM cafe.news")
  List<New> getAllNews();

  @Select("SELECT newDescription FROM cafe.news WHERE newId = #{newId}")
  String getNewDescription(int newId);

  @Select("SELECT newDetail FROM cafe.news WHERE newId = #{newId}")
  String getNewDetail(int newId);

  @Select("SELECT * FROM cafe.news WHERE newId = #{newId}")
  New getNewById(int newId);
}
