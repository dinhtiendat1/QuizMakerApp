package com.huflit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.huflit.entity"})  
public class QuizMaker2Application {

	public static void main(String[] args) {
		SpringApplication.run(QuizMaker2Application.class, args);
	}

}
