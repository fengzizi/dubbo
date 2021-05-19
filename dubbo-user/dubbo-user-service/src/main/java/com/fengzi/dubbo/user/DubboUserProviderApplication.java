package com.fengzi.dubbo.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.fengzi")
@EnableElasticsearchRepositories(basePackages = {"com.fengzi"})
public class DubboUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboUserProviderApplication.class, args);
    }

}
