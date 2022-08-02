package com.ticket.my.book.service.jwt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ticket.my.book.security.UserDetailsAuthenticationService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsAuthenticationService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(" Token " +requestTokenHeader);
		
		String userName = null;
		String jwtToken = null;
		
		if ( requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				userName = jwtUtil.getUsernameToken(jwtToken);
			} catch ( IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch ( ExpiredJwtException e) {
				System.out.println("Jwt token has expired");
			}
		} else {
			System.out.println(" JWT Token does not begin with bearer");
		}
		
		if ( userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = userDetailsService.loadUserByUsername(userName);
			if ( jwtUtil.validateToken(jwtToken, userDetail)) {
				UsernamePasswordAuthenticationToken userNamePasswordAuthenicationToken = 
						new UsernamePasswordAuthenticationToken(userDetail, null, new ArrayList<>());
				userNamePasswordAuthenicationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenicationToken);
				
			}
		}
		filterChain.doFilter(request, response);
	}
	
	

}
