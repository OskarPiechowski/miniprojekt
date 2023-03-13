package com.miniprojekt.miniprojekt;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppScannerConfig {
    @Bean
    public Scanner addScanner(){
        Scanner scan = new Scanner(System.in);
        return scan;
    }
}
