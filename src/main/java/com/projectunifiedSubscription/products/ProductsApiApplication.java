package com.projectunifiedSubscription.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProductsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApiApplication.class, args);
	}

}
