package com.mahi.recipe.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mahi.recipe.exception.RecipeNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandling {

	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<?> recipeNotFoundException(RecipeNotFoundException recipeNotFoundException){
		Map<String,Object> error=new LinkedHashMap<>();
		error.put("error", "Created");
		error.put("timestamp", LocalDateTime.now());
		error.put("details", recipeNotFoundException.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}




