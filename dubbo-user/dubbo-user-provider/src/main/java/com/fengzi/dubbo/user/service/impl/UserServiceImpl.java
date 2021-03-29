package com.fengzi.dubbo.user.service.impl;

import com.fengzi.dubbo.user.service.UserService;
import com.fengzi.dubbo.user.vo.UserVo;
import org.apache.dubbo.config.annotation.DubboService;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@DubboService
public class UserServiceImpl implements UserService {


    @Override
    public UserVo findUserById(String id) {
        UserVo vo = new UserVo();
        vo.setUserId(id);
        vo.setUserName(id + "的姓名");

        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            vo.setIp(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
