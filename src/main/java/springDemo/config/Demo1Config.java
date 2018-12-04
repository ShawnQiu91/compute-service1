package springDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.example.computeservice1.controller")
@Configuration
public class Demo1Config {
    @Bean
    public Demo1Config  configBean(){
        return new Demo1Config();
    }
}
