package com.miniprojekt.miniprojekt;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppConverter {

    AppRepositoryCsv appRepositoryCsv = new AppRepositoryCsv("toCSV");

    AppRepositoryJson appRepositoryJson = new AppRepositoryJson("toJSON");

    Scanner scan = new Scanner(System.in);
    AppScannerConfig scannerConfig;
    AppSystem appSystem = new AppSystem();
    private AppRepoInterface appRepoInterface;

    public AppConverter(){

    }
    public AppConverter(AppRepoInterface appRepoInterface) {
    }

    public void starts() {
        System.out.println("Select what type of conversion would you like to do: ");
        printChoices();
        System.out.println(" ");
        selectChoice(scan.nextInt());
    }

    public void printChoices() {
        List<Choice> choices = appSystem.getChoices();
        for (int i = 0; i < choices.size(); i++) {
            System.out.printf(" %d. %s", i + 1, choices.get(i).getName());
        }
    }

    public int selectChoice(int number) {
        if (number < 1 || number > appSystem.numberOfChoices()) {
            System.out.println("there is no such choice");
        }
        String choiceResult = appSystem.choiceNumber(number -1);
        System.out.println(choiceResult);
        if (number == 1) {
            appRepositoryCsv.converter();
        }
        if (number == 2) {
            appRepositoryJson.converter();
        }
        return number;
    }
}
