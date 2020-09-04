package com.steinko.reactsprinboottutorial.RestfulWebService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class TodoService  {
	
	private static final Logger logger = LoggerFactory.getLogger(TodoService.class);
	
    @Autowired
	private TodoRepository repository;
	
	
	public List<Todo> getTodos(String name) { 
	
		 return repository.findByName(name);	
	}
	

	public void deleteTodo(String name, Long id) {
		
		repository.deleteById(id);
	}


	public void createTodo(Todo todo) {
		
		validateEntity(todo);
		repository.save(todo);
	}
	
	
	private void validateEntity(Todo todo) {
		
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Todo>> constraintViolations = validator.validate(todo);

		for (ConstraintViolation<Todo> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}
	

}
