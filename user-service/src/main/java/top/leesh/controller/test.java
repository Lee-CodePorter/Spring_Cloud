package top.leesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.misc.Unsafe;

import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.controller
 * @createdate 2019/8/20 14:13
 */
@RestController
public class test
{
    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public  String test()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        ServiceInstance instance = instances.get(0);
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);
//        System.out.println(unsafe.getAddress(1));
        String address="http://"+instance.getHost()+":"+instance.getPort()+"/info";
        String object = restTemplate.getForObject(address, String.class);
        System.out.println(object+"这是user-service里面的获取远程实例");
        return  object+"这是user-service里面的获取远程实例";
    }


}
