package com.course;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;


/**
 * @author: huangxiang
 * @create: 2018/5/28 19:20
 * @description:
 */
@EnableScheduling
@SpringBootApplication
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class,args);
    }

    @PreDestroy
    public void close(){
        Application.context.close();
    }

}
