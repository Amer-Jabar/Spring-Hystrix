package Spring.SpringHystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/*
Importabt Note: Only use the following dependencies for Hystrix:
org.springframework.cloud.netflix.hystrix - @EnableHystrix
com.netflix.hystrix.contrib.javanica - Hystrix Annotations
*/
@SpringBootApplication
@EnableHystrix
public class SpringHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixApplication.class, args);
        
        normalMethod();
    }
    
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public static void normalMethod() {
        System.out.println("Normal");
    }
    
    public static void fallbackMethod() {
        System.err.println("fuck");
    }
    
}
