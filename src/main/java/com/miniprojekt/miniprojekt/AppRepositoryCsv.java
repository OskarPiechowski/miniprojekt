package com.miniprojekt.miniprojekt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
@Component
public class AppRepositoryCsv extends Choice implements AppRepoInterface {
    public AppRepositoryCsv() {
    }

    public AppRepositoryCsv(String name) {
        super("Convert from Json to Csv");

    }

    @Override
    public void converter() {
        File jsonFilePath = new File("E:\\Dev\\Chmura\\miniprojekt\\src\\main\\resources\\products.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(jsonFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
            jsonNode.fields().forEachRemaining(entry -> {
                csvSchemaBuilder.addColumn(entry.getKey());
            });
            CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

            CsvMapper csvMapper = new CsvMapper();
        String csv;
        try {
            csv = csvMapper.writerFor(JsonNode.class)
                    .with(csvSchema)
                    .writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(csv);
    }
}