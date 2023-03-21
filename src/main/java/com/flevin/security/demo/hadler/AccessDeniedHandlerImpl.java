package com.flevin.security.demo.hadler;

import com.alibaba.fastjson.JSON;
import com.flevin.security.demo.util.WebUtils;
import com.flevin.security.demo.web.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e)
            throws IOException, ServletException {
        // 给前端ResponseResult的响应结果
        ResponseResult<Void> result =
                new ResponseResult<>(
                        HttpStatus.FORBIDDEN.value(), "权限不足，请联系管理员！");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
