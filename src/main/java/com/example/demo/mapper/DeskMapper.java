package com.example.demo.mapper;

import com.example.demo.domain.Desk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeskMapper {

  @Select("SELECT * FROM cafe.desk WHERE DeskId = #{deskId} AND StoreId = #{storeId}")
  Desk getDeskByDeskId(int deskId, int storeId);

  @Select("SELECT * FROM cafe.desk WHERE StoreId = #{storeId}")
  List<Desk> getDeskByStoreId(int storeId);

}
