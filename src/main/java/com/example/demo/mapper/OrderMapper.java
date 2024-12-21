package com.example.demo.mapper;

import com.example.demo.domain.UserDesk;
import com.example.demo.domain.UserGame;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

  @Select("SELECT * FROM cafe.user_desk WHERE OrderId = #{orderId}")
  UserDesk findUserDeskById(int orderId);

  @Select("SELECT * FROM cafe.user_game WHERE ObserveId = #{observeId}")
  UserGame findUserGameById(int observeId);

  @Insert("INSERT INTO cafe.user_desk(OrderID, UserID, DeskID, StoreID, StartTime, EndTime, Price, OrderStatus)" +
      " values (#{orderId}, #{userId}, #{deskId}, #{storeId}, #{startTime}, DATE_ADD(#{startTime},INTERVAL 1 HOUR), #{price}, #{orderStatus}) ")
  void addOrder(UserDesk userDesk);

  @Select("SELECT OrderId FROM cafe.user_desk")
  List<Integer> findAllOrderId();

  @Select("SELECT ObserveId FROM cafe.user_game")
  List<Integer> findAllObserveId();
}
