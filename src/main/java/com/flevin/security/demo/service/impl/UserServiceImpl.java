package com.flevin.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flevin.security.demo.pojo.entity.User;
import com.flevin.security.demo.service.UserService;
import com.flevin.security.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author flevin
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-03-21 13:11:23
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




