package com.ews.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ews.springboot.web")
public class EwsAlertWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwsAlertWebApplication.class, args);
	}
}
