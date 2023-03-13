package com.miniprojekt.miniprojekt;

import java.util.List;

public class AppSystem implements MenuInterface{

    ChoiceSelector choiceSelector = new ChoiceSelector();
    @Override
    public List<Choice> getChoices() {
        return choiceSelector.getChoices();
    }

    @Override
    public int numberOfChoices() {
        return getChoices().size();
    }

    @Override
    public String choiceNumber(int index) {
        Choice choice = choiceSelector.choiceNumber(index);
        return choice.getName();
    }
}
