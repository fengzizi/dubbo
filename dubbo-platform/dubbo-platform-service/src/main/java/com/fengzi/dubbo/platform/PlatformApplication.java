package com.fengzi.dubbo.platform;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.fengzi"},exclude = SecurityAutoConfiguration.class)
@EnableElasticsearchRepositories(basePackages = {"com.fengzi"})
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper","com.fengzi.dubbo.platform.mapper"})
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

}
