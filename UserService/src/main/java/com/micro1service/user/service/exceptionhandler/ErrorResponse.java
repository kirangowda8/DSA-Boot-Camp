package com.micro1service.user.service.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private Date timeStamp;
	private String message;
	private HttpStatus status;
	private String details;
	
	
	
}