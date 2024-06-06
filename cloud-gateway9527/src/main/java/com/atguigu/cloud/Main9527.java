package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.ZonedDateTime;

@SpringBootApplication
@EnableDiscoveryClient
public class Main9527 {
    public static void main(String[] args) {
        SpringApplication.run(Main9527.class,args);
    }
//    public static void main(String[] args)
//    {
//        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
//        System.out.println(zbj);
//    }
}
