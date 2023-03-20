package com.flevin.security.demo.service.impl;

import com.flevin.security.demo.entity.LoginUser;
import com.flevin.security.demo.service.LogoutService;
import com.flevin.security.demo.util.RedisCache;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LogoutServiceImpl implements LogoutService {
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult<Void> logout() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        long userId = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userId);
        return new ResponseResult<>(200, "退出登录成功！");
    }
}
