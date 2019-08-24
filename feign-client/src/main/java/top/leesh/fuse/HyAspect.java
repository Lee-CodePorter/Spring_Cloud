package top.leesh.fuse;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李书涵
 * @package_name: top.leesh.fuse
 * @createdate 2019/8/22 11:17
 */
public class HyAspect
{
    /**
     *@Description //TODO   key(服务的id) value(服务的拦截器)
     *@Param
     *@Return
     */
    private Map<String,HystixCmd> map;
    public  Object interceptor(ProceedingJoinPoint point)
    {
        HystixCmd hystixCmd=map.get("service-id");
        return  null;
    }
}
