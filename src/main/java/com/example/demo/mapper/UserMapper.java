package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * FROM cafe.users WHERE UserID = #{id}")
  User findUserById(int id);

  @Select("SELECT * FROM cafe.users WHERE UserName = #{username}")
  User findUserByName(String username);

  @Insert("INSERT INTO cafe.users(UserID, UserPassword, UserName, UserSex, UserTelephone)" +
      "values (#{userId},#{userPassword},#{userName},#{userSex},#{userTelephone})")
  int addUser(User user);

}
