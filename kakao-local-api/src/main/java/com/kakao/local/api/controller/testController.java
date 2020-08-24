package com.kakao.local.api.controller;

import org.springframework.boot.SpringApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableWebMvc
@SpringBootApplication
public class testController {

	public static void main(String[] args) {
        SpringApplication.run(testController.class, args);

        log.info("========================================================");
        log.info("=                                                      =");
        log.info("=                testController		                 =");
        log.info("=                                                      =");
        log.info("========================================================");

    }
}
