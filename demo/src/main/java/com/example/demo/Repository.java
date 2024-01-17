package com.example.demo;

import org.apache.tomcat.websocket.AuthenticationException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@org.springframework.stereotype.Repository
public class Repository {

    Repository() throws MalformedURLException {

    }

    private final Logger logger = LoggerFactory.getLogger(Repository.class);
    @Value("${chatpgt.apikey}")
    private String API_KEY;
    private final URL CHATGPT_ENDPOINT = new URL("https://api.openai.com/v1/chat/completions");
    @Value("${chatgpt.usedModel}")
    private String USED_MODEL;

    /**
     * Sends prompt to OpenAI Endpoint and receives an answer as string
     * @param prompt The prompt.
     * @return The answer as string
     */
    public String sendPromptToOpenAI(String prompt) throws IOException, AuthenticationException {
        // TODO: If required, check if token size less than 8k

        HttpURLConnection connection = (HttpURLConnection) CHATGPT_ENDPOINT.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        if(API_KEY != null)
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        else {
            logger.error("No API-Key provided!");
            throw new AuthenticationException("No API-Key provided!");
        }

        JSONObject data = createRequest(prompt);
        connection.setDoOutput(true);
        connection.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines()
                .reduce((a,b) -> a + b).get();

        return new JSONObject(output).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
    }

    public JSONObject createRequest(String prompt) {
        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject arrayEntity = new JSONObject();
        arrayEntity.put("role", "user");
        arrayEntity.put("content", prompt);
        jsonArray.put(arrayEntity);
        data.put("model", USED_MODEL);
        data.put("messages", jsonArray);

        return data;
    }

}
