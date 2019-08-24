package top.leesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }


//    @Bean
//    public CommonsMultipartResolver commonsMultipartResolver()
//    {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxInMemorySize(1048576);
//        return resolver;
//    }

}
