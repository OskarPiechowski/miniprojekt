package com.miniprojekt.miniprojekt;

import java.util.ArrayList;
import java.util.List;

public class ChoiceSelector {
    private final List<Choice> choices = new ArrayList<>();

    public ChoiceSelector(){
        choices.add(new AppRepositoryCsv("scv"));
        choices.add(new AppRepositoryJson("json"));
    }

    public List<Choice> getChoices() {
        return choices;
    }
    public Choice choiceNumber(int number){
        return choices.get(number);
    }
}
