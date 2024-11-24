package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author 何佳臣
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-11-09 17:22:07
* @Entity generator.pojo.User
*/
@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);
    @Insert("INSERT INTO user (username, password, create_time, update_time) VALUES (#{username},#{password},NOW(),NOW())")
    void registry(String username, String password);
    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);
    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);
    @Update("update user set password=#{password},update_time=#{updateTime} where id=#{id}")
    void updatePwd(User user);
}
