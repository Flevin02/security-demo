package com.flevin.security.demo.service;

import com.flevin.security.demo.entity.User;
import com.flevin.security.demo.web.ResponseResult;

import java.util.Map;

public interface LoginService {
    public ResponseResult<Map<String,String>> login(User user);
}
