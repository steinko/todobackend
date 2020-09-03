package com.steinko.reactsprinboottutorial.RestfulWebService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/user")
public class TodoController {
	
	
	private final TodoService service;
	
	public TodoController(TodoService service)  {
		this.service = service;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	
	@GetMapping(value= "{user_name}/todos")
	public List<TodoDto> getTodos(@PathVariable("user_name") String userName) {
		
		List<TodoDto> result;		
		result = service.getTodos(userName);
		return result;
		
	}
	
	
	@DeleteMapping(value= "{user_name}/todo/{id}")
	public List<TodoDto> deleteTodo(@PathVariable("user_name") String userName,@PathVariable("id") String id) {
	
		Long longId=Long.parseLong(id);;  
		service.deleteTodo(userName,longId);
		List<TodoDto> result = null;
		return result;
		
	}
	
	
	@PostMapping(value = "{user_name}/todo")
	public void createTodo(@PathVariable("user_name") String userName,@RequestBody TodoDto dto){
		
		service.createTodo(dto);
	}
			               
}
