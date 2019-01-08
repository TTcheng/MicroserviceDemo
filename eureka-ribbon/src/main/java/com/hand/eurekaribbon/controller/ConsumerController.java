package com.hand.eurekaribbon.controller;

import com.hand.eurekaribbon.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        /*
         * 负载均衡测试
         */
        //return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
        /*
         *  Hystrix断路器测试
         *  启动eureka-server、compute-service、eureka-ribbon
         *  访问http://localhost:3333/add，页面显示：30;关闭compute-service再次访问，显示error
         */
        return computeService.addService();
    }
}