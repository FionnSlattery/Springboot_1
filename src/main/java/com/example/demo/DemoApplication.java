package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	@RequestMapping("/")
	public String hello1() {
		return "A new way of saying hello";
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "Hello Again";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

