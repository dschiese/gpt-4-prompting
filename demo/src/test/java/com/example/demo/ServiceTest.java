package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ServiceTest {


     @Autowired
     private Service service;
     private Logger logger = LoggerFactory.getLogger(ServiceTest.class);

     @Test
    public void getFilesFromDirTest() throws IOException {
         List<String> files = service.getFilesFromDir("gpt-4-experiments");
         assertNotNull(files);
         logger.info("Files: {}", files);
     }

     @Test
     public void calculateIndexTest() throws Exception {
          List<String> files = service.getFilesFromDir("gpt-4-experiments");
          files.forEach(file -> {
              JSONObject fileContent = null;
              try {
                  fileContent = new JSONObject(new String(Files.readAllBytes(ResourceUtils.getFile("classpath:gpt-4-experiments/" + file).toPath())));
                  JSONArray experiments = fileContent.getJSONArray("explanations");
                  assertEquals(-1,service.calculateIndex(experiments));
              } catch (JSONException | IOException e) {
                  throw new RuntimeException(e);
              }
          });
     }

}
