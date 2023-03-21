package com.flevin.security.demo.controller;

import com.flevin.security.demo.pojo.entity.User;
import com.flevin.security.demo.service.LoginService;
import com.flevin.security.demo.service.LogoutService;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private LogoutService logoutService;
    @PostMapping("/login")
    public ResponseResult<Map<String, String>> login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult<Void> logout() {
        return logoutService.logout();
    }
}
