package com.miniprojekt.miniprojekt;

import java.util.List;

public interface MenuInterface {

    List<Choice> getChoices();

    int numberOfChoices();

    String choiceNumber(int index);

}
