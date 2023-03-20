package com.flevin.security.demo.mapper;

import com.flevin.security.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {
    @Autowired
    private UserMapper mapper;

    @Test
    void testGetUser() {
        List<User> users = mapper.selectList(null);
        User user = users.get(0);
        System.out.println(user);
    }
}
