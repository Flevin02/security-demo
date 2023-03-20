package com.flevin.security.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Test
    void contextLoads() {
        PasswordEncoder pwd = new BCryptPasswordEncoder();
        // 加密
        String encode1 = pwd.encode("123");
        String encode2 = pwd.encode("123");
        System.out.println(encode1);
        System.out.println(encode2);
        // 比较密码
        boolean b = pwd.matches("123", encode1);
        boolean c = pwd.matches("123", encode2);
        System.out.println(b);
        System.out.println(c);
    }
    /**
     * 生成jwt
     */
    @Test
    void testJWT() {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis + 10000);
        JwtBuilder builder = Jwts.builder()
                .setId("2")
                .setSubject("testJWT")
                .setIssuedAt(new Date())
                //.setExpiration(date)
                .claim("userId","123")
                .signWith(SignatureAlgorithm.HS256, "flevin");
        String str = builder.compact();
        System.out.println(str);
    }

    /**
     * 解析jwt
     */
    @Test
    void testParse() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyIiwic3ViIjoidGVzdEpXVCIsImlhdCI6MTY3OTI5ODg4MiwidXNlcklkIjoiMTIzIn0.3eAm939EGvqclT06QXwPaXP1ARK98hibO0-nB-c5T3Q";
        Claims body = Jwts.parser().setSigningKey("flevin").parseClaimsJws(jwt).getBody();
        System.out.println(body);
    }
}
