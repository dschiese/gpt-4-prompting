package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileNotFoundException;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication {

	@Autowired
	private Service service;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
