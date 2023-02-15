package com.burak.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * onepay
 * Created by Alexey Burak
 * Feb 2023
 */

@SpringBootApplication
@EnableScheduling
public class UserRunner {
    public static void main(String[] args) {
        SpringApplication.run(UserRunner.class, args);
    }
}
