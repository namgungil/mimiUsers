package com.example.mimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MimiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimiApplication.class, args);
    }

}
