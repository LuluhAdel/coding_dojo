package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class StaticTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaticTestApplication.class, args);
	}
@RequestMapping("/")
public String home() {
	return "index.html";
}
}
