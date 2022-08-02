package com.ticket.my.book.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.my.book.service.UserServiceImpl;
import com.ticket.my.book.user.credentials.UserCredential;

@RestController
@CrossOrigin( origins = "http://localhost:3000")
@RequestMapping("/user")
public class LogInController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/login")
	public String login(@RequestBody UserCredential userCred) throws Exception {
		return userService.checkUserLogin(userCred);
	}
	
}
