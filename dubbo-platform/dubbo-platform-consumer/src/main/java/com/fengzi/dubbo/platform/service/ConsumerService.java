package com.fengzi.dubbo.platform.service;

import com.fengzi.dubbo.user.vo.UserVo;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
public interface ConsumerService {

    UserVo findUserById(String message);
}
