package com.fengzi.dubbo.platform.controller;

import com.fengzi.dubbo.common.commons.JsonResp;
import com.fengzi.dubbo.platform.entity.User;
import com.fengzi.dubbo.platform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * 用户信息Controller
 *
 * @author fujian
 * @version : Ver 1.0
 */
@RestController
@RequestMapping(value = "/api/user")
@Transactional
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     *
     * @param user
     * @return 返回值JsonResp
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResp addUser(User user) {
        log.debug("添加用户信息");
        userService.save(user);
        return JsonResp.ok(user);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return 返回值JsonResp
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResp updateUser(User user) {
        log.debug("修改用户信息");
        userService.updateById(user);
        return JsonResp.ok(user);
    }

    /**
     * 根据id查找用户信息
     *
     * @param id
     * @return 返回值JsonResp
     */
    @RequestMapping(value = "/selectOne")
    public JsonResp selectUser(Long id) {
        log.debug("查找用户信息");
        User user = userService.getById(id);
        return JsonResp.ok(user);
    }

}