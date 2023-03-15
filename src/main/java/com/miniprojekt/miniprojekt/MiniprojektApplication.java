package com.miniprojekt.miniprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class MiniprojektApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MiniprojektApplication.class, args);
        AppConverter appConverter = new AppConverter();
        appConverter.starts();

    }

}
