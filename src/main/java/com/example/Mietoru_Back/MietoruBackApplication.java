package com.example.Mietoru_Back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MietoruBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MietoruBackApplication.class, args);
    }
}