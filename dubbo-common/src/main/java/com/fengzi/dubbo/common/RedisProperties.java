package com.fengzi.dubbo.common;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/04/02
 */
@Component
@Data
@NacosConfigurationProperties(dataId = "redis.yaml",prefix = "spring", autoRefreshed = true, type = ConfigType.YAML)
public class RedisProperties {


    private Redis redis;

    @Data
    public static class Redis {
        private Integer database;

        private String host;

        private Integer port;
    }

}
