package com.ticket.my.book.singup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.my.book.service.UserServiceImpl;
import com.ticket.my.book.user.User;

@RestController
@CrossOrigin( origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserSingUpController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/signup")
	public String singUp(@RequestBody User user) {
		userService.saveUser(user);
		return "User saved successfully";
	}
	
	

}
