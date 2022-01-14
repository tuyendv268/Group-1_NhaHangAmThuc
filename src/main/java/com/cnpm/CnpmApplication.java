package com.cnpm;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.expression.Dates;

@SpringBootApplication
public class CnpmApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CnpmApplication.class, args);
		
		System.out.print("hi");
		 LocalDate date = LocalDate.now();
		System.out.println(java.sql.Date.valueOf(date));
	}

}
