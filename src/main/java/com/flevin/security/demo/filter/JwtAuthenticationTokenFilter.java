package com.flevin.security.demo.filter;

import com.flevin.security.demo.pojo.LoginUser;
import com.flevin.security.demo.util.JwtUtil;
import com.flevin.security.demo.util.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        // 1.获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行，让后面的过滤器操作
            filterChain.doFilter(request, response);
            return;
        }

        // 2.解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("非法token！");
        }

        // 3.获取userId,从redis获取信息
        LoginUser loginUser = redisCache.getCacheObject("login:" + userId);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("当前用户未登录！");
        }

        // 4.封装Authentication
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

        // 5.存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 放行
        filterChain.doFilter(request,response);
    }
}
