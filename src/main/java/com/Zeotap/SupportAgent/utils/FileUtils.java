package com.Zeotap.SupportAgent.utils;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileUtils {
    public static void saveAsJson(Map<String, String> data, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), data);
    }

    public static Map<String, String> loadFromJson(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), Map.class);
    }
}
