package com.my.lunch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableWebMvc
@SpringBootApplication
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
