package top.leesh.rpc;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author 李书涵
 * @package_name: top.leesh.rpc
 * @createdate 2019/8/22 10:25
 */
@Component
public class FeignSpare implements  Feign
{
    @Override
    public String info() {
        System.out.println("这是备用");
        return "这是备用";
    }

    @Override
    public String obj(Map<String, String> map) {
        System.out.println("这是备用");
        return "这是备用";
    }

    @Override
    public String par(String name, Integer age) {
        System.out.println("这是备用");
        return "这是备用";
    }

    @Override
    public String upload(MultipartFile file) {
        System.out.println("这是备用");
        return "这是备用";
    }
}
