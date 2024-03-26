package com.zhiwen.basic.shejimoshi.chainResponsibility.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 5:09 下午
 */
@Configuration
@ComponentScan(basePackages = "com.zhiwen.basic.shejimoshi.chainResponsibility.spring")
public class AppConfig {
   /* @Autowired
    private ManagerHandler managerHandler;

    @Autowired
    private DirectorHandler directorHandler;

    @Autowired
    private CEOHandler ceoHandler;

    @Bean
    public Handler chainOfResponsibility() {
        managerHandler.setNextHandler(directorHandler);
        directorHandler.setNextHandler(ceoHandler);
        return managerHandler;
    }*/
}
