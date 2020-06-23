package com.five.monkey.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eureka/info")
public class EurekaInfoController {

    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, List<String>> getInfo() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> serviceIdList = discoveryClient.getServices();
        serviceIdList.forEach(serviceId -> {
            List<String> serviceInstanceStringList = new ArrayList<>();
            List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceId);
            serviceInstanceList.forEach(serviceInstance -> {
                String host = serviceInstance.getHost();
                String instanceId = serviceInstance.getInstanceId();
                int port = serviceInstance.getPort();
                URI uri = serviceInstance.getUri();
                StringBuilder builder = new StringBuilder();
                builder.append("\"host\":").append(host).append(",").append("\"instanceId\":").append(instanceId).append(",")
                        .append("\"port\":").append(port).append(",").append("\"uri\":").append(uri.toString());
                serviceInstanceStringList.add(builder.toString());
            });
            map.put(serviceId, serviceInstanceStringList);
        });
        return map;
    }
}
