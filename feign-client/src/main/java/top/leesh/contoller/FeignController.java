package top.leesh.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.leesh.rpc.Feign;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李书涵
 * @package_name: top.leesh.contoller
 * @createdate 2019/8/21 17:27
 */
@RestController
public class FeignController
{
    @Autowired
    private Feign feign;

    @GetMapping("/ferpc")
    public  String fe()
    {
        return feign.info();
    }

    @GetMapping("/obj")
    public String  map()
    {
        Map<String, String> map = new HashMap<>();
        map.put("key", "这是通过feign调用对象调用");
        return feign.obj(map);
    }

    @GetMapping("/par")
    public  String par()
    {
        return feign.par("李书涵",21);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file)
    {
        System.out.println(file);
       return feign.upload(file);
    }
}
