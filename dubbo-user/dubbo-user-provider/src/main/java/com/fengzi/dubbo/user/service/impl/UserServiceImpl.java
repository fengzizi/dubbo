package com.fengzi.dubbo.user.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.fengzi.dubbo.common.RedisProperties;
import com.fengzi.dubbo.user.service.UserService;
import com.fengzi.dubbo.user.vo.UserVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/26
 */
@DubboService
public class UserServiceImpl implements UserService {

    /**
     * 实时获取
     */
    @NacosValue(value = "${spring.redis.database}", autoRefreshed = true)
    private Integer redisDatabase;

    @NacosValue(value = "${spring.redis.host}", autoRefreshed = true)
    private String redisHost;

    @NacosValue(value = "${spring.redis.port}", autoRefreshed = true)
    private Integer redisPort;

    /**
     * 实时获取
     */
    @Resource
    private Environment env;

    /**
     * 实时获取
     */
    @Resource
    private RedisProperties redisProperties;

    @Override
    public UserVo findUserById(String id) {
        UserVo vo = new UserVo();
        vo.setUserId(id);
        vo.setUserName("redisDatabase=" + redisDatabase + ",redisHost=" + redisHost + ",redisPort=" + redisPort);
        System.err.println("spring.redis.host=" + env.getProperty("spring.redis.host"));

        System.err.println("redisProperties=spring.redis.host=" + redisProperties.getRedis().getHost());

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
