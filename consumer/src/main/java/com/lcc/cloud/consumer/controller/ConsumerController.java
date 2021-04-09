package com.lcc.cloud.consumer.controller;

import com.alibaba.nacos.client.naming.utils.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cong-Cong Liao
 * @since 2021-04-09
 **/
@RestController
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/a")
    public List<ServiceInstance> instances() {
        List<ServiceInstance> instances = discoveryClient.getInstances("nacos");
        return instances;
    }

    @GetMapping("/index")
    public String index() {
        List<ServiceInstance> instancesList = discoveryClient.getInstances("nacos");
        // 获取实例范围内的随机数
        int index = ThreadLocalRandom.current().nextInt(instancesList.size());
        ServiceInstance serviceInstance = instancesList.get(index);
        // 获取实例的uri
        String uri = serviceInstance.getUri() + "/index";
        // 调用
        return restTemplate.getForObject(uri,String.class);
    }

}
