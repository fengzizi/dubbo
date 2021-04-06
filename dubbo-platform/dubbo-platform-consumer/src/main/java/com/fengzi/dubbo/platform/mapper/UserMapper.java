package com.fengzi.dubbo.platform.mapper;

import com.fengzi.dubbo.platform.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 * 用户信息Mapper
 * @author fujian
 * @version : Ver 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}