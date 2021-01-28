package com.nh.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service1Application {

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;
    @Value("${common.name}")
    private String config1;

    @GetMapping(value="/configs")
    public String getConfigs(){
        //return config2;
        return configurableApplicationContext.getEnvironment().getProperty("common.name");
    }
}
