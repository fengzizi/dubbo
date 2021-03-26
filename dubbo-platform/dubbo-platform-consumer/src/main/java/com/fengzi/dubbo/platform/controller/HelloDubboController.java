package com.fengzi.dubbo.platform.controller;

import com.fengzi.dubbo.platform.service.ConsumerService;
import com.fengzi.dubbo.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@RestController
public class HelloDubboController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/findUserById")
    public UserVo findUserById(String name) {
        return consumerService.findUserById(name);
    }
}
