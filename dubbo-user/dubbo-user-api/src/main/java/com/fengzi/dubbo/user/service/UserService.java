package com.fengzi.dubbo.user.service;

import com.fengzi.dubbo.user.vo.UserVo;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
public interface UserService {
    /**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return UserVo
     */
    UserVo findUserById(String id);
}
