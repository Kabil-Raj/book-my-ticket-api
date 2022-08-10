package com.ticket.my.book.gateway.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class BookMyTicketApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyTicketApiGatewayApplication.class, args);
	}

}
