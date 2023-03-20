package com.flevin.security.demo.controller;

import com.flevin.security.demo.service.LogoutService;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LogoutController {
    @Autowired
    private LogoutService service;

    @PostMapping("/logout")
    public ResponseResult<Void> logout() {
        return service.logout();
    }
}
