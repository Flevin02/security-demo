package com.flevin.security.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flevin.security.demo.entity.LoginUser;
import com.flevin.security.demo.entity.User;
import com.flevin.security.demo.mapper.UserMapper;
import com.flevin.security.demo.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 自定义UserDetailsService实现类
 * 重写loadUserByUsername方法，从数据库查询用户信息
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);

        // user为空表示用户名错误
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        // 根据用户名查询权限信息并添加到LoginUser中
        List<String> authorities = new ArrayList<>(Arrays.asList("hello", "add"));

        // 封装成UserDetails对象返回
        return new LoginUser(user,authorities);
    }
}
