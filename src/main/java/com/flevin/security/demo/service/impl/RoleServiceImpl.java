package com.flevin.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flevin.security.demo.pojo.entity.Role;
import com.flevin.security.demo.service.RoleService;
import com.flevin.security.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author flevin
* @description 针对表【sys_role(角色表)】的数据库操作Service实现
* @createDate 2023-03-21 11:36:05
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




