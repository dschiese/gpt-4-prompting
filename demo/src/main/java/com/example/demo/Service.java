package com.example.demo;

import org.apache.tomcat.websocket.AuthenticationException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    public Service() {

    }

    private final Logger logger = LoggerFactory.getLogger(Service.class);
    @Autowired
    private Repository repository;
    private final int RUNS = 5;

    /**
     * Fetches all files within the passed classpath-dir
     * @param dir passed dir within the classpath
     * @return List of files as Strings
     */
    public List<String> getFilesFromDir(String dir) throws FileNotFoundException {
        File folder = ResourceUtils.getFile(dir);
        File[] files = folder.listFiles();
        return Arrays.stream(files).map(File::getName).toList();
    }




    public void sendPromptsForDifferentModel() throws FileNotFoundException {
        List<String> files = getFilesFromDir("gpt-4-experiments");

        files.forEach(fileName -> {
            logger.info("Start GPT-4 experiments for file {}", fileName);
            try {
                executeExperiments(fileName, "gpt-4-experiments");
                logger.info("Finished GPT-4 experiments for file {}", fileName);
            } catch(Exception e) {
                logger.error("Exception during execution of GPT-4 experiments with file: {}", fileName);
                e.printStackTrace();
            }
        });
    }

    public void executeExperiments(String fileName, String dir) throws IOException, AuthenticationException {
        JSONObject fileContent = new JSONObject(new String(Files.readAllBytes(ResourceUtils.getFile("gpt-4-experiments/" + fileName).toPath())));
        JSONArray experiments = fileContent.getJSONArray("explanations");

        int index = calculateIndex(experiments);
        if(index != -1) {
            for (int i = 0; i < experiments.length(); i++) {
                logger.info("--------------------- {}. experiment", i);
                String prompt = experiments.getJSONObject(i).getString("prompt");
                String gptExplanation;
                int counter = 0;
                do{
                    logger.info("Trying to send request");
                    gptExplanation = repository.sendPromptToOpenAI(prompt);
                    experiments.getJSONObject(i).put("gptExplanation", gptExplanation);
                    counter++;
                }while(gptExplanation == null && counter < RUNS);
                if(gptExplanation == null) {
                    logger.error("Error while computing gptExplanation in file {} at index {}", fileName, i);
                    break;
                }
            }
            fileContent.put("explanations", experiments);
            writeNewFile(fileContent, fileName);
        }
        else
            logger.info("The file {} was already executed with GPT-4", fileName);
    }

    public int calculateIndex(JSONArray experiments) {
        for(int i = 0; i < experiments.length(); i++) {
            if(experiments.getJSONObject(i).isNull("gptExplanation"))
                return i;
        }
        return -1; // This file is finished
    }

    public void writeNewFile(JSONObject fileContent, String oldFileName) throws IOException {
        File file = ResourceUtils.getFile("gpt-4-experiments/" + oldFileName);
        file.delete();
        String filename = oldFileName.replace(".json", "_" + LocalDateTime.now() + ".json");
        FileWriter fileWriter = new FileWriter("gpt-4-experiments/" + filename);
        fileWriter.write(fileContent.toString());
        fileWriter.flush();
        fileWriter.close();
    }

}
