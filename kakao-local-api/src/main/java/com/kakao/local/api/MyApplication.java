package com.kakao.local.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.kakao.local.api.controller.testController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(testController.class, args);

        log.info("========================================================");
        log.info("=                                                      =");
        log.info("=                KaKao Local API		                 =");
        log.info("=                                                      =");
        log.info("========================================================");

	}

}
