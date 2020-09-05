package com.leyou.controller;

import com.leyou.client.UserClient;
import com.leyou.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@DefaultProperties(defaultFallback = "defaultFallBack")
@RestController
@RequestMapping("consumer")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;


    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        User user = userClient.queryById(id);
        return user;
    }


    //@HystrixCommand(fallbackMethod = "queryByIdFallBack")
//    @HystrixCommand(commandProperties = {
//            //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//
//        if(id % 2 == 0){
//            throw new RuntimeException();
//        }
//
//        String url = "http://localhost:8081/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

    public User queryByIdFallBack(@PathVariable("id") Long id) {
        User user = new User();

        user.setId(1L);
        user.setUsername("服务异常");
        return user;
    }

    // 默认的异常处理
    public User defaultFallBack() {
        User user = new User();

        user.setId(1L);
        user.setUsername("服务异常");
        return user;
    }

//    @GetMapping("{id}")
//    public User consume(@PathVariable("id") Long id) {
//
//        // String url = "http://localhost:8081/user/" + id;
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//
//        // 从实例中获取ip和端口号
//
//        ServiceInstance serviceInstance = instances.get(0);
//        String hostAndPort = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//
//        System.out.println(hostAndPort);
//
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//
//        return user;
//    }
}