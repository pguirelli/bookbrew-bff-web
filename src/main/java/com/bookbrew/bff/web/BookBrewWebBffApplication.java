package com.bookbrew.bff.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookBrewWebBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookBrewWebBffApplication.class, args);
	}

}
