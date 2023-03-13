package com.miniprojekt.miniprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MiniprojektApplication {

    public static void main(String[] args)  {
        SpringApplication.run(MiniprojektApplication.class, args);
        AppConverter appConverter = new AppConverter();
        appConverter.starts();

    }

}
