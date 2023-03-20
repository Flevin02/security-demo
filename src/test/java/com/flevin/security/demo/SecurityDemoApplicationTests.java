package com.flevin.security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Test
    void contextLoads() {
        PasswordEncoder pwd = new BCryptPasswordEncoder();
        // 加密
        String encode = pwd.encode("123");
        System.out.println(encode);
        // 比较密码
        boolean b = pwd.matches("123", encode);
        System.out.println(b);
    }

}
