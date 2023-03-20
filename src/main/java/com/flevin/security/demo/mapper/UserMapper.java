package com.flevin.security.demo.mapper;

import com.flevin.security.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author flevin
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2023-03-20 16:40:47
* @Entity com.flevin.security.demo.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




