package com.fengzi.dubbo.platform;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboPlatformProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboPlatformProviderApplication.class, args);
    }

}
