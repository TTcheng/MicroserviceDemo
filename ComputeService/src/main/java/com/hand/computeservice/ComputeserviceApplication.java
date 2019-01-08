package com.hand.computeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputeserviceApplication.class, args);
    }

}

