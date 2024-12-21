package com.example.demo.mapper;

import com.example.demo.domain.UserDesk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDeskMapper {

  @Select("SELECT * FROM cafe.user_desk WHERE OrderId = #{orderId}")
  UserDesk getUserDeskById(int orderId);

  @Select("SELECT * FROM cafe.user_desk WHERE UserId = #{userId}")
  List<UserDesk> getAllUserDeskByUserId(int userId);

}
