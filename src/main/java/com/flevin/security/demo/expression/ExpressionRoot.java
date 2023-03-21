package com.flevin.security.demo.expression;

import com.flevin.security.demo.pojo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限校验方法
 */
@Component("expressionRoot")
public class ExpressionRoot {
    public boolean hasAuthority(String authority) {
        // 获取当前登录用户的权限
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        List<String> permissions = loginUser.getPermissions();
        // 判断用户权限是否包含接口的权限字符串
        return permissions.contains(authority);
    }
}
