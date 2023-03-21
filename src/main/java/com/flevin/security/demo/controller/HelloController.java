package com.flevin.security.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('dev:code:pull')")
    public String hello() {
        return "hello security!";
    }

    @GetMapping("/haha")
    @PreAuthorize("hasAuthority('haha')")
    public String haha() {
        return "happy everyone!";
    }
}
