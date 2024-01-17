package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) throws FileNotFoundException {

		Service service = new Service();

		service.sendPromptsForDifferentModel();

	}

}
