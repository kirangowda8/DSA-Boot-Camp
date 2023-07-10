package com.micro1service.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHAndler {

	@ExceptionHandler(ResoureceNoFoundException.class)
	public ResponseEntity<Map<String, Object>> notfound(ResoureceNoFoundException exception) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", exception.getMessage());
		map.put("status", exception.getStatus());
		map.put("success", false);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
