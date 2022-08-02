package com.ticket.my.book.service.global.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {
	
	private String description;
	
	private int statusCode;
	

}
