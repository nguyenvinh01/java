package com.example.demo_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJavaApplication.class, args);
	}

}
