package com.flevin.security.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flevin.security.demo.pojo.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author flevin
* @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
* @createDate 2023-03-21 11:36:05
* @Entity com.flevin.security.demo.entity.Menu
*/
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> getPermsByUserId(Long userId);
}




