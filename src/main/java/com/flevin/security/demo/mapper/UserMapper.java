package com.flevin.security.demo.mapper;

import com.flevin.security.demo.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author flevin
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2023-03-21 13:11:23
* @Entity com.flevin.security.demo.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




