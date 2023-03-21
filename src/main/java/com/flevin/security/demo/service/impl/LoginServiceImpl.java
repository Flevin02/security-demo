package com.flevin.security.demo.service.impl;

import com.flevin.security.demo.pojo.LoginUser;
import com.flevin.security.demo.pojo.entity.User;
import com.flevin.security.demo.service.LoginService;
import com.flevin.security.demo.util.JwtUtil;
import com.flevin.security.demo.util.RedisCache;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult<Map<String, String>> login(User user) {
        // 使用ProviderManager的authenticate方法进行验证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        user.getUserName(), user.getPassword()
                );
        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);
        // 如果校验失败
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("用户名或密码错误！");
        }
        // 自己生成jwt发送给前端
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        String jwt = JwtUtil.createJWT(String.valueOf(userId));
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        // 系统用户相关信息放入redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        return new ResponseResult<>(200, "登录成功！", map);
    }
}
