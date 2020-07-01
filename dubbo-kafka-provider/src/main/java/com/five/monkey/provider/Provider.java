package com.five.monkey.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import java.util.concurrent.CountDownLatch;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDubbo
@EnableKafka
@EnableEurekaClient
public class Provider {

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(Provider.class, args);

		//hold住应用，防止provider退出
		new CountDownLatch(1).await();
	}
	
}
