package com.nh.nacos.nacossimpledemo.helloworld;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;

import java.util.Properties;

public class SimpleDemoMain {
    public static void main(String[] args) throws Exception{
        // 使用nacos client获取nacos服务上的配置信息
        String serverAddr = "49.235.114.120:8848";
        String dataId = "nacos-simple-demo.yaml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId,group,5000);
        System.out.println(content);
    }
}
