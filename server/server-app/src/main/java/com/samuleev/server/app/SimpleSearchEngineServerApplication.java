package com.samuleev.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.samuleev")
public class SimpleSearchEngineServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSearchEngineServerApplication.class, args);
	}
}
