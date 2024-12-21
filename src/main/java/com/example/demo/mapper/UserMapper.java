package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

  @Select("SELECT * FROM cafe.users WHERE UserId = #{userId}")
  User findUserById(int userId);

  @Select("SELECT * FROM cafe.users WHERE UserName = #{username}")
  User findUserByName(String username);

  @Insert("INSERT INTO cafe.users(UserId, UserPassword, UserName, UserSex, UserTelephone)" +
      "values (#{userId},#{userPassword},#{userName},#{userSex},#{userTelephone})")
  void addUser(User user);

  @Select("SELECT UserName FROM cafe.users WHERE UserId = #{userId}")
  String getUserNameByUserId(int userId);

  @Select("SELECT UserId FROM cafe.users")
  List<Integer> getAllUserId();
}
