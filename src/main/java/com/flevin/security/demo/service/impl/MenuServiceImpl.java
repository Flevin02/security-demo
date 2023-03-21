package com.flevin.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flevin.security.demo.pojo.entity.Menu;
import com.flevin.security.demo.service.MenuService;
import com.flevin.security.demo.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author flevin
* @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
* @createDate 2023-03-21 11:36:05
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




