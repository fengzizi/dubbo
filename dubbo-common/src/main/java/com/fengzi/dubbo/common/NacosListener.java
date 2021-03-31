package com.fengzi.dubbo.common;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.stereotype.Component;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/03/31
 */
@Component
@NacosPropertySource(dataId = "redis.yaml", autoRefreshed = true, type = ConfigType.YAML)
public class NacosListener {

    @NacosConfigListener(dataId = "redis.yaml")
    public void onMessage(String msg) {
        System.out.println(msg);
    }
}