package com.five.monkey.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import java.util.concurrent.CountDownLatch;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDubbo
@EnableEurekaClient
public class Consumer {

    public static void main(String[] args) throws InterruptedException{

        SpringApplication.run(Consumer.class, args);

        //hold住应用，防止provider退出
        new CountDownLatch(1).await();
    }
}
