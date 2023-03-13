package com.miniprojekt.miniprojekt;

import org.springframework.stereotype.Component;

@Component
public class Choice {

    private String name;

    public Choice(String name){
        this.name = name;
    }

    public Choice() {
    }

    public String getName() {
        return name;
    }
}
