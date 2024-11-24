package com.itheima.service.impl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author 何佳臣
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-11-09 17:22:07
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
      User user=  userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userMapper.registry(username,password);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id= (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public Result updatePwd(Map<String, String> map) {
        String oldpwd = map.get("old_pwd");
        String newpwd = map.get("new_pwd");
        String repwd = map.get("re_pwd");
        if (!StringUtils.hasLength(oldpwd)||!StringUtils.hasLength(newpwd)||!StringUtils.hasLength(repwd)){
            return Result.error("参数有误!");
        }
        Map<String,Object> clamins= ThreadLocalUtil.get();
        String username= (String) clamins.get("username");
        User user = userMapper.findByUsername(username);
        String password = user.getPassword();
        oldpwd= DigestUtils.md5DigestAsHex(oldpwd.getBytes());
        if (!password.equals(oldpwd)){
            return Result.error("密码错误!");
        }
        if (!newpwd.equals(repwd)){
            return Result.error("密码不一致!");
        }
       password = DigestUtils.md5DigestAsHex(newpwd.getBytes());
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(password);
        userMapper.updatePwd(user);
        return Result.success();
    }
}
