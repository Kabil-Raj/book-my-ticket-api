package com.ticket.my.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ticket.my.book.*")
@EntityScan(basePackages = "com.ticket.my.book.user")
@EnableJpaRepositories(basePackages = "com.ticket.my.book.reposiotry")
@EnableEurekaClient
public class BookMyTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyTicketApplication.class, args);
	}
}
