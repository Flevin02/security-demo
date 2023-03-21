package com.flevin.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flevin.security.demo.pojo.entity.RoleMenu;
import com.flevin.security.demo.service.RoleMenuService;
import com.flevin.security.demo.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author flevin
* @description 针对表【sys_role_menu】的数据库操作Service实现
* @createDate 2023-03-21 11:36:05
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{

}




