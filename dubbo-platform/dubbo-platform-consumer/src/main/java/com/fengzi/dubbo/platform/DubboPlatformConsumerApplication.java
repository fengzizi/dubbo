package com.fengzi.dubbo.platform;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.fengzi"})
@EnableElasticsearchRepositories(basePackages = {"com.fengzi"})
public class DubboPlatformConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboPlatformConsumerApplication.class, args);
    }

}
