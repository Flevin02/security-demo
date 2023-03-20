package com.flevin.security.demo.config;

import com.flevin.security.demo.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    /**
     * 配置过滤器链
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        return http
                //基于token,不需要csrf,所以关闭
                .csrf().disable()
                //不通过session过去SecurityContext
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests(authorize -> authorize
                        // 请求放开
                        // 把登录接口放行(允许匿名访问登录接口)
                        .antMatchers("/user/login")
                        .anonymous() // 只有未登录的人才能访问
                        .antMatchers("/demo/hello")
                        .permitAll() // 不管是否登录都能访问
                        // 除了上述的接口可以匿名访问,其他地址的访问均需验证权限
                        .anyRequest().authenticated())
                //配置自定义的JwtAuthenticationToken这个过滤器的位置
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager()
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
