package com.fengzi.dubbo.platform.service.impl;

import com.fengzi.dubbo.platform.service.ConsumerService;
import com.fengzi.dubbo.user.service.UserService;
import com.fengzi.dubbo.user.vo.UserVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @DubboReference
    private UserService userService;

    @Override
    public UserVo findUserById(String id) {
        return userService.findUserById(id);
    }
}
