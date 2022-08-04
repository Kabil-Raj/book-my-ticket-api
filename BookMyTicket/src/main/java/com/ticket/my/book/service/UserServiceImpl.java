package com.ticket.my.book.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticket.my.book.reposiotry.TicketBookedRepository;
import com.ticket.my.book.reposiotry.UserRepository;
import com.ticket.my.book.security.UserDetailsAuthenticationService;
import com.ticket.my.book.service.jwt.JwtTokenUtil;
import com.ticket.my.book.custom.exception.UserNotFoundException;
import com.ticket.my.book.model.TicketBooked;
import com.ticket.my.book.model.User;
import com.ticket.my.book.user.credentials.UserCredential;

@Service
public class UserServiceImpl {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UserDetailsAuthenticationService userDetailsService;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TicketBookedRepository ticketBookRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public String checkUserLogin(UserCredential userCred) throws Exception {
		String userName = findUser(userCred).getUserName();
		authenticationCheck(userName, userCred.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		String jwtToken = jwtTokenUtil.generateToken(userDetails);
		return jwtToken;
	}

	public void saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	private User findUser(UserCredential userCred) throws UserNotFoundException {
		User user = userRepo.findUserByEmail(userCred.getEmailId());
		if ( user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user;

	}

	private void authenticationCheck(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED ", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		} 

	}

        public void bookTicket(TicketBooked ticketDetails) {
            ticketDetails.setTicketIssuedDate(new Date());
            ticketBookRepo.save(ticketDetails);
        }

}
