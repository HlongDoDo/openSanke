package com.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangsenwei
 * @Description 消费者启动类
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class ConsumerMain8040 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8040.class,args);
    }
}
