package com.flevin.security.demo.hadler;

import com.alibaba.fastjson.JSON;
import com.flevin.security.demo.util.WebUtils;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证失败接口的实现类
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e)
            throws IOException, ServletException {
        // 给前端ResponseResult的响应结果
        ResponseResult<Void> result =
                new ResponseResult<>(
                        HttpStatus.UNAUTHORIZED.value(), "登录认证失败，请重新登录！");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
