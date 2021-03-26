package com.fengzi.dubbo.user.service.impl;

import com.fengzi.dubbo.user.service.UserService;
import com.fengzi.dubbo.user.vo.UserVo;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserVo findUserById(String userId) {
        UserVo vo = new UserVo();
        vo.setUserId("1");
        vo.setUserName("姓名");
        System.err.println("------接受到请求-------");
        return vo;
    }
}
