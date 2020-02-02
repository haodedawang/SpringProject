package com.demo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan("com.demo.order.entity")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker //想查看链路信息 需要此注解，如果是为了使用hystrix熔断则不需要加这个注解，http://localhost:9002/actuator/hystrix.stream
@EnableHystrixDashboard//想利用dashboard查看链路信息 需要此注解，如果是为了使用hystrix熔断则不需要加这个注解，http://localhost:9002/hystrix
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
