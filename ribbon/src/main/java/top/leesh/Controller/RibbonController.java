package top.leesh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author 李书涵
 * @package_name: top.leesh.Controller
 * @createdate 2019/8/21 14:09
 */
@RestController
public class RibbonController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     *@Description //TODO   手动负载均衡
     *@Param []
     *@Return java.lang.String
     */
    @GetMapping("/ribbon")
    public  String ribbon()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");

        ServiceInstance instance = LoadBalancing(instances);

        String url="http://"+instance.getHost()+":"+instance.getPort()+"/info";
        String template = restTemplate.getForObject(url, String.class);
        System.out.println(template+"这是手动负载均衡");
        return  template;
    }


    @GetMapping("/ban")
    public  String ban()
    {
        String template = restTemplate.getForObject("http://eureka-client/info", String.class);
        return template+"这是自动负载均衡";
    }


    /**
     *@Description //TODO   负载均衡
     *@Param [instances]
     *@Return org.springframework.cloud.client.ServiceInstance
     */
    private ServiceInstance LoadBalancing(List<ServiceInstance> instances)
    {
        if(instances!=null&&instances.size()>0)
        {
             return  instances.get(new Random().nextInt(instances.size()));
        }
        return  null;
    }


}
