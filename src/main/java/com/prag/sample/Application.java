package com.prag.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static int USER_COUNT = 0;
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }
}
