package com.flevin.security.demo.controller;

import com.flevin.security.demo.entity.User;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return service.login(user);
    }
}
