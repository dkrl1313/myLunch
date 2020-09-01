package com.my.lunch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.my.lunch",
        "com.kakao.local"
})
public class MyLunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLunchApplication.class, args);

        log.info("========================================================");
        log.info("=                                                      =");
        log.info("=                What is my Lunch!??!?!                =");
        log.info("=                                                      =");
        log.info("========================================================");

    }

}
