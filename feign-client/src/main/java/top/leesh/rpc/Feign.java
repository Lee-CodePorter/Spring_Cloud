package top.leesh.rpc;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author 李书涵
 * @package_name: top.leesh.rpc
 * @createdate 2019/8/21 17:24
 */
@FeignClient(name = "eureka-client-lee",fallback = FeignSpare.class)
public interface Feign
{
    @GetMapping("/info")
    String info();


    @PostMapping("/obj")
    String obj(@RequestBody Map<String,String> map);

    @GetMapping("/par")
    public  String par(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @PostMapping(value = "/uploadfile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(MultipartFile file);
}
