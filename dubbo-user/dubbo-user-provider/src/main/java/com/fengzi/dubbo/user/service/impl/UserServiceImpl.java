package com.fengzi.dubbo.user.service.impl;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.fengzi.dubbo.user.service.UserService;
import com.fengzi.dubbo.user.vo.UserVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@DubboService
public class UserServiceImpl implements UserService {

    @NacosValue(value = "${spring.redis.database}", autoRefreshed = true)
    private Integer redisDatabase;

    @NacosValue(value = "${spring.redis.host}", autoRefreshed = true)
    private String redisHost;

    @NacosValue(value = "${spring.redis.port}", autoRefreshed = true)
    private Integer redisPort;

    @Override
    public UserVo findUserById(String id) {
        UserVo vo = new UserVo();
        vo.setUserId(id);
        vo.setUserName("redisDatabase=" + redisDatabase + ",redisHost=" + redisHost + ",redisPort=" + redisPort);
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            vo.setIp(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return vo;
    }

    @Component
    @NacosPropertySource(dataId = "redis.yaml", autoRefreshed = true, type = ConfigType.YAML)
    public class NacosListener {

        @NacosConfigListener(dataId = "redis.yaml")
        public void onMessage(String msg) {
            System.out.println(msg);
        }
    }
}
