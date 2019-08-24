package top.leesh.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.POST;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author 李书涵  eureka测试
 * @package_name: top.leesh.controller
 * @createdate 2019/8/20 14:06
 */
@RestController
public class EurekaController
{
    @GetMapping("/info")
    public  String testinfo()
    {
        return  "成功(eurekaclient)"+"这是eureka客户端";
    }


    @PostMapping("/obj")
    public String obj(@RequestBody Map<String,String> map)
    {
        System.out.println(map.get("key"));
        return  "成功调用对象"+map.get("key");
    }


    @GetMapping("/par")
    public  String par(String name,Integer age)
    {
        System.out.println("成功"+"两个参数");
        return  name+":"+age;
    }

    @PostMapping("/uploadfile")
    public  String upload(MultipartFile file)
    {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        return file.getOriginalFilename();
    }

}
