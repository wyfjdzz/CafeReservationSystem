package com.example.demo.mapper;

import com.example.demo.domain.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

  @Select("SELECT * FROM cafe.store WHERE StoreId = #{storeId}")
  Store getStoreByStoreId(int storeId);

  @Select("SELECT StoreName FROM cafe.store WHERE StoreId = #{storeId}")
  String getStoreNameByStoreId(int storeId);

  @Select("SELECT cafe.store.StoreId FROM cafe.store WHERE StoreName = #{storeName}")
  int getStoreIdByStoreName(String storeName);

  @Select("SELECT cafe.desk.Deskid FROM cafe.desk WHERE StoreId = #{storeId}")
  List<Integer> getAllDeskByStoreId(int storeId);

  @Select("SELECT cafe.store.StoreId FROM cafe.store")
  List<Integer> getAllStore();

  @Select("SELECT StoreName FROM cafe.store")
  List<String> getAllStoreNames();
}
