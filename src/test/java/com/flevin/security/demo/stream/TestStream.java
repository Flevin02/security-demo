package com.flevin.security.demo.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    @Test
    void testList() {
        List<String> list = new ArrayList<>(
                Arrays.asList("张三风", "张思2", "里斯", "王武", "赵六", "钱七"));
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        map.put("d", "D");
        map.put("e", "E");
        map.values().stream()
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
