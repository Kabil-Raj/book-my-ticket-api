package com.ticket.my.book.movie.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ticket.my.book.movie.service.*")
@EnableJpaRepositories(basePackages = "com.ticket.my.book.movie.service.repository")
@EntityScan(basePackages = "com.ticket.my.book.movie.service.model")
@EnableEurekaClient
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
