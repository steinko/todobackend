package com.steinko.reactsprinboottutorial.RestfulWebService;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TodoTestData {
	private List<TodoDto> todos;
	private String todosjson;
	private static final Logger logger = LoggerFactory.getLogger(TodoTestData.class);
	
	public TodoTestData ()  {
	 SimpleDateFormat df
	   = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	 Date date;
		try  {		
	          String toParse = "01-01-2020 12:00:00";
	          date = df.parse(toParse);
		 } catch (ParseException ex)
		{
			 date = new Date();
			 logger.info(ex.getMessage());	 
		}
		
		
	 
	  todos = new ArrayList<TodoDto>();
	  todos.add(new TodoDto(0, "Stein", "Fix mutter", date, false));
	  todos.add(new TodoDto(1, "Stein", "Fix kajakk", date, false));
			  
	   ObjectMapper objectMapper = new ObjectMapper();
	   
	   try {
	   
         todosjson =   objectMapper.writeValueAsString(todos);
	   } catch (JsonProcessingException ex)
	   {
		   logger.info(ex.getMessage());
	   }
	  }

	public List<TodoDto> getTodos() {
		return todos;
	}

	public String getTodosJson() {
		return todosjson;
	}

}
