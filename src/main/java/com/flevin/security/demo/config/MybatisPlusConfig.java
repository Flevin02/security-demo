package com.flevin.security.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.flevin.security.demo.mapper")
public class MybatisPlusConfig {
}
