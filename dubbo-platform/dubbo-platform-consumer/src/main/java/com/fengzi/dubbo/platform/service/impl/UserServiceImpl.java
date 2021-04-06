package com.fengzi.dubbo.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzi.dubbo.platform.mapper.UserMapper;
import com.fengzi.dubbo.platform.entity.User;
import com.fengzi.dubbo.platform.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceImpl
 * 用户信息ServiceImpl
 * @author fujian
 * @version : Ver 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
}
