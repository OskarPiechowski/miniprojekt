package com.miniprojekt.miniprojekt;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@Component
public class AppRepositoryJson extends Choice implements AppRepoInterface {

    public AppRepositoryJson(){

    }
    public AppRepositoryJson(String name) {
        super("Convert from Csv to Json");

    }

    @Override
    public void converter() {
        String csvFilePath = "E:\\Dev\\Chmura\\miniprojekt\\src\\main\\resources\\products.csv";
        String line = " ";
        String cvsSplitBy = ", ";
        JSONArray jsonArray = new JSONArray();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String[] headers = br.readLine().split(cvsSplitBy);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], data[i]);
                }
                jsonArray.put(jsonObject);
            }
            System.out.println(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

