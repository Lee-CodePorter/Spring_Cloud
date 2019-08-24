package top.leesh.filter;

import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李书涵
 * @package_name: top.leesh.filter
 * @createdate 2019/8/23 11:14
 */
public class RaterLimitFilter extends ZuulFilter
{
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    private  AtomicInteger is=new AtomicInteger();
    private  Object lock=new Object();
    private  static  Long WINDOWS_TIME=60*1000L;
    private  static  Integer WINDWOWS_MAX_ACCECC_COUNT=20;
    private Map<String, Accessing> acceccMappring=new HashMap<>();
//    private



    {
        new Thread(()->{
            while (true)
            {
                try {
                    Thread.sleep(1000);
                    //看第一次访问的时间判断该值知否需要清空
                    HashSet<String> deadKeys = new HashSet<>();
                    acceccMappring.forEach((k,v)->
                    {
                         Date firstTime = v.getFirstTime();
                         long futuerDeadTime = firstTime.getTime() + WINDOWS_TIME;
                         if(System.currentTimeMillis()>=futuerDeadTime)
                         {
                             deadKeys.add(k);
                         }
                    });
                    deadKeys.forEach((k)->{
                        acceccMappring.remove(k);
                    });

                    if(acceccMappring.size()==0)
                    {

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }









    public RaterLimitFilter() {
        super();
    }

    @Override
    public boolean isStaticFilter() {
        return super.isStaticFilter();
    }

    @Override
    public String disablePropertyName() {
        return super.disablePropertyName();
    }

    @Override
    public boolean isFilterDisabled() {
        return super.isFilterDisabled();
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public int compareTo(ZuulFilter filter) {
        return super.compareTo(filter);
    }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException
    {
        if(is.get()>0)
        {
            synchronized (lock)
            {

            }
        }
        String addr = request.getRemoteAddr();
        //判断是否达到最大访问次数
        if(!acceccMappring.containsKey(addr))
        {
            acceccMappring.put(addr, new Accessing());

        }
        else
        {
            Accessing accessing = acceccMappring.get(addr);
            if(accessing.getCurrentCount().get()>WINDWOWS_MAX_ACCECC_COUNT)
            {

            }
        }
        return null;
    }
}
