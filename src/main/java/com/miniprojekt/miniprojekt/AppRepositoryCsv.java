package com.miniprojekt.miniprojekt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Component
public class AppRepositoryCsv extends Choice implements AppRepoInterface {
    public AppRepositoryCsv() {
    }

    public AppRepositoryCsv(String name) {
        super("Convert from Json to Csv");

    }

    @Override
    public void converter() throws IOException {
        File jsonFile = new File("E:\\Dev\\Chmura\\miniprojekt\\src\\main\\resources\\products.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonFile);
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = rootNode.elements().next();
        Iterator<String> fieldNames = firstObject.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            csvSchemaBuilder.addColumn(fieldName);
        }
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        File csvFile = new File("E:\\Dev\\Chmura\\miniprojekt\\src\\main\\resources\\newProducts.csv");
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(csvFile, rootNode);
    }
}