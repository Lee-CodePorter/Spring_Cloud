package top.leesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/**
 *@Description //TODO      开启zuul代理功能
 *@Param
 *@Return 
 */
@EnableZuulProxy
public class GetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }



    @Bean
    public PatternServiceRouteMapper routeMapper()
    {
        return  new PatternServiceRouteMapper("(?<name>.*)-(?<version>v.*$)","${version}/${name}");
    }

}
