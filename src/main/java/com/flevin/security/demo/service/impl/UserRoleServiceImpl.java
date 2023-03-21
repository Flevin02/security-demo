package com.flevin.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flevin.security.demo.pojo.entity.UserRole;
import com.flevin.security.demo.service.UserRoleService;
import com.flevin.security.demo.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author flevin
* @description 针对表【sys_user_role】的数据库操作Service实现
* @createDate 2023-03-21 11:36:05
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




