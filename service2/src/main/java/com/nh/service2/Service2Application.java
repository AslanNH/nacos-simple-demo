package com.nh.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service2Application {

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;
    @Value("${common.name}")//value注解在服务端更新配置后，并不会同步更新
    private String config2;

    @GetMapping(value="/configs")
    public String getConfigs(){
        //return config2;
        return configurableApplicationContext.getEnvironment().getProperty("common.name");
    }
}
