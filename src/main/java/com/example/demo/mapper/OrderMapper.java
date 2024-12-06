package com.example.demo.mapper;

import com.example.demo.domain.UserDesk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

  @Insert("INSERT INTO cafe.user_desk(OrderID, UserID, DeskID, StoreID, StartTime, EndTime, Price, OrderStatus)" +
      " values (#{orderId}, #{userId}, #{deskId}, #{storeId}, NOW(), DATE_ADD(NOW(),INTERVAL 1 HOUR), #{price}, #{orderStatus}) ")
  int addOrder(UserDesk userDesk);

  @Select("SELECT * FROM cafe.user_desk WHERE UserID = #{id}")
  UserDesk findUserDeskByUserId(int userId);
}
