package com.itheima.service;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;

import java.util.Map;

/**
* @author 何佳臣
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-11-09 17:22:07
*/
public interface UserService {

    User findByUsername(String username);

    void register(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);
    Result updatePwd(Map<String, String> map);

}
