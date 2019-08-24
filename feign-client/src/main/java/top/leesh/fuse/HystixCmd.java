package top.leesh.fuse;

/**
 * @author 李书涵
 * @package_name: top.leesh.fuse
 * @createdate 2019/8/22 11:14
 */
public interface HystixCmd
{
    /**
     *@Description //TODO    拦截请求
     *@Param [request]
     *@Return java.lang.Object
     */
    Object interceptor(Object request);
    /***
     *@Description //TODO    放行请求
     *@Param [request]
     *@Return java.lang.Object
     */
    Object pass(Object request);


    /**
     *@Description //TODO   拦截状态
     *@Param [request]
     *@Return void
     */
    void status(FuseType request);




}
