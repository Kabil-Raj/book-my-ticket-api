package com.ticket.my.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.my.book.model.TicketBooked;
import com.ticket.my.book.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class TicketBookController {
    
    @Autowired
    private UserServiceImpl userService;
    
    @PostMapping("/book/ticket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketBooked ticketDetails ) {
           userService.bookTicket(ticketDetails);
           return new ResponseEntity<String>("Your ticket for the movie " +ticketDetails.getMovieName()+ " has been booked successfully!",HttpStatus.ACCEPTED); 
    }

}
