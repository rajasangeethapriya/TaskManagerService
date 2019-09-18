package com.capsule.taskmanager.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capsule.taskmanager.model.Task;
import com.capsule.taskmanager.service.TaskService;



@RestController
public class TaskController {
	//header("Access-Control-Allow-Origin: *");
	@Autowired
	TaskService operate;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public Task add(@RequestParam("task") String task, @RequestParam("parentTask") String parentTask,
			@RequestParam("priority") int priority, 
			@RequestParam("startDate") @DateTimeFormat(pattern = "M/d/yyyy") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "M/d/yyyy") String endDate,
			@RequestParam("endFlag") int endFlag) {
		Task t = new Task();
		String response="";
		t.setTask(task);
		t.setParentTask(parentTask);
		t.setPriority(priority);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");
		t.setStartDate(Date.valueOf(LocalDate.parse(startDate,df)));
		t.setEndDate(Date.valueOf(LocalDate.parse(endDate,df)));
		t.setEndFlag(endFlag);
		
		boolean insertedTask = operate.addTask(t);
		if(insertedTask)
		{
			response=  "Success";	
		}
		else
		{
			response = "Failure"	;
		}
		
		return t;
		

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getTask", method = RequestMethod.GET)
	public List<Task> getTask()
	{
		List<Task> task = operate.getallTask();
		//model.addAllAttributes(task);
		System.out.println(task.toString());
		return task;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public Task update(@RequestParam("task") String task, @RequestParam("parentTask") String parentTask,
			@RequestParam("priority") int priority, 
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-M-d") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-M-d") String endDate, 
			@RequestParam("endFlag") int endFlag, ModelMap model) {
		Task t = new Task();
		
		t.setTask(task);
		t.setParentTask(parentTask);
		t.setPriority(priority);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-M-d");
		t.setStartDate(Date.valueOf(LocalDate.parse(startDate,df)));
		t.setEndDate(Date.valueOf(LocalDate.parse(endDate,df)));
		t.setEndFlag(endFlag);
		
		t = operate.updateTask(t);
		System.out.println(t.toString());
		model.addAttribute(t);

		return t;

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updateExistingTask", method = RequestMethod.POST)
	public Task updateExistingTask(@RequestParam("task") String task, @RequestParam("parentTask") String parentTask,
			@RequestParam("priority") int priority, 
			@RequestParam("startDate") @DateTimeFormat(pattern = "M/d/yyyy") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "M/d/yyyy") String endDate, 
			@RequestParam("endFlag") int endFlag, ModelMap model) {
		Task t = new Task();
		
		t.setTask(task);
		t.setParentTask(parentTask);
		t.setPriority(priority);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");
		t.setStartDate(Date.valueOf(LocalDate.parse(startDate,df)));
		t.setEndDate(Date.valueOf(LocalDate.parse(endDate,df)));
		t.setEndFlag(endFlag);
		
		t = operate.updateTask(t);
		System.out.println(t.toString());
		model.addAttribute(t);

		return t;

	}

}
