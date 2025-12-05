package com.academy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;



public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        // Read JSON to string
        String jsonContent = FileUtils.readFileToString(
            new File(System.getProperty("user.dir") + "/src/test/java/com/academy/data/PurchaseOrder.json"),
            StandardCharsets.UTF_8);

        // String to HashMap - Jackson Databind
        JsonMapper mapper = new JsonMapper();
        
        List<HashMap<String, String>> data = 
            mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

        return data;
    }
}
