package top.leesh.filter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李书涵
 * @package_name: top.leesh.filter
 * @createdate 2019/8/23 11:18
 */
public class Accessing
{
    /**
     *@Description //TODO   第一次访问的时间
     * 在access新建时创建
     *@Param
     *@Return
     */
    private final Date firstAccessTime=new Date();
    
    
    /**
     *@Description //TODO     当前访问的次数
     *@Param 
     *@Return
     */
    private AtomicInteger currentCount= new AtomicInteger(0);


    public  Date getFirstTime()
    {
        return  firstAccessTime;
    }
    public  AtomicInteger getCurrentCount()
    {
        return  currentCount;
    }

}
