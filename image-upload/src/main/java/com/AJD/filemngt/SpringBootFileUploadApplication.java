package com.AJD.filemngt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.AJD.filemngt.*")
public class SpringBootFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFileUploadApplication.class, args);
    }

}
