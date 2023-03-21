package com.flevin.security.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {
    @PostMapping("/hello")
    //@PreAuthorize("@expressionRoot.hasAuthority('dev:code:pull')")
    public String hello() {
        return "hello security!";
    }

    @PostMapping("/haha")
    //@PreAuthorize("hasAuthority('haha')")
    public String haha() {
        return "happy everyone!";
    }
}
