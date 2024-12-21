package com.example.demo.mapper;

import com.example.demo.domain.Desk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeskMapper {

  @Select("SELECT * FROM cafe.desk WHERE DeskId = #{deskId} AND StoreId = #{storeId}")
  Desk getDesk(int deskId, int storeId);

  @Select("SELECT * FROM cafe.desk WHERE StoreId = #{storeId}")
  List<Desk> getDeskByStoreId(int storeId);

  @Select("SELECT DeskId FROM cafe.desk WHERE StoreId = #{storeId}")
  List<Integer> getAllDeskInStore(int storeId);

  @Update("UPDATE cafe.desk SET DeskStatus = #{deskStatus} WHERE DeskId = #{deskId}")
  void updateDeskStatus(int deskId, int deskStatus);

  @Update("UPDATE cafe.desk SET DeskCapacity = #{deskCapacity}, StoreId = #{storeId} WHERE DeskId = #{deskId} AND StoreId = #{storeId}")
  void updateDesk(Desk desk);

  @Insert("INSERT INTO cafe.desk(DeskId, StoreId, DeskCapacity, DeskStatus) VALUE (#{deskId},#{storeId},#{deskCapacity},#{deskStatus})")
  void uploadDesk(Desk desk);
}
