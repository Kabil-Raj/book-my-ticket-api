package com.ticket.my.book.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookMyTicketServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyTicketServiceRegistryApplication.class, args);
	}

}
