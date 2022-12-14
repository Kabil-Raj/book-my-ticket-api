package com.ticket.my.book.service.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	
	private static final long JWT_TOKEN_TIME = 5 * 60 * 60;
	
	private String secret = "book-my-ticket";
	
	public String getUsernameToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken( token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken( String token, Function<Claims,T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimResolver.apply(claims);
	}
	
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		System.out.println(" Token Date " +expiration+ " new Date " +new Date());
		return expiration.before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		return doGenerateToken(claims,userDetails.getUsername());
	}


	private String doGenerateToken(Map<String, Object> claims, String username) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
							 .setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_TIME * 1000) )
							 .signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = userDetails.getUsername();
		return ( userName.equals(getUsernameToken(token)) && !isTokenExpired(token));
	}
	
	
	
	

}
