package com.cnpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CnpmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnpmApplication.class, args);
        
		System.out.print("Welcome to Spring Initializr");
	}

}
