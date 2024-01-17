package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class Controller {


    @Autowired
    private Service service;

    @GetMapping("/execute")
    public ResponseEntity<?> executeTests() throws FileNotFoundException {
        service.sendPromptsForDifferentModel();
        return new ResponseEntity<>("Yay", HttpStatusCode.valueOf(200));
    }

}
