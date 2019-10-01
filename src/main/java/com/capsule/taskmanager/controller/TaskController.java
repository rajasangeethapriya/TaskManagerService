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

import com.capsule.taskmanager.model.Project;
import com.capsule.taskmanager.model.Task;
import com.capsule.taskmanager.model.Users;
import com.capsule.taskmanager.service.ProjectService;
import com.capsule.taskmanager.service.TaskService;
import com.capsule.taskmanager.service.UsersService;



@RestController
public class TaskController {
	//header("Access-Control-Allow-Origin: *");
	@Autowired
	TaskService operate;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	ProjectService projectService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public Task add(@RequestParam("project") String project,  @RequestParam("task") String task, @RequestParam("parentTask") String parentTask,
			@RequestParam("priority") int priority, 
			@RequestParam("startDate") @DateTimeFormat(pattern = "M/d/yyyy") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "M/d/yyyy") String endDate,
			@RequestParam("user")  String user,
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
		t.setProjectid(projectService.getprojectId(project));
		

		
		Task insertedTask = operate.addTask(t);
		userService.updateTaskId(insertedTask.getTaskid(),user);
		userService.updateProjectId(insertedTask.getProjectid(), user);
		t.setTaskid(insertedTask.getTaskid());
		
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
			@RequestParam("startDate") @DateTimeFormat(pattern = "M/dd/yyyy") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "M/dd/yyyy") String endDate, 
			@RequestParam("endFlag") int endFlag, ModelMap model) {
		Task t = new Task();
		
		t.setTask(task);
		t.setParentTask(parentTask);
		t.setPriority(priority);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("M/dd/yyyy");
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
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate, 
			@RequestParam("endFlag") int endFlag, ModelMap model) {
		Task t = new Task();
		
		t.setTask(task);
		t.setParentTask(parentTask);
		t.setPriority(priority);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		t.setStartDate(Date.valueOf(LocalDate.parse(startDate,df)));
		t.setEndDate(Date.valueOf(LocalDate.parse(endDate,df)));
		t.setEndFlag(endFlag);
		
		t = operate.updateTask(t);
		System.out.println(t.toString());
		model.addAttribute(t);

		return t;

	}
	
@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Users add(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("employeeid") String employee_id) {
		Users user = new Users();
		System.out.println(employee_id);
		String response="";
		
		user.setEmployeeid(Integer.parseInt(employee_id));
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setTask_id(0);
		user.setProjectid(0);
		
		Users insertedUser = userService.addUsers(user);
		
		
		return insertedUser;
		

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<Users> getUsers()
	{
		List<Users> users = userService.getallUsers();
		//model.addAllAttributes(task);
		System.out.println(users.toString());
		return users;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public Users updateUsers(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("employeeid") int employee_id) {
		
		Users user = new Users();
		
		user.setEmployeeid(employee_id);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user = userService.updateUsers(user);
		//model.addAttribute(user);

		return user;

	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public boolean deleteUser(@RequestParam("employeeid")  int employee_id) {
		boolean isDeleted = userService.deleteUser(employee_id);
		return isDeleted;

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public Project addProject(@RequestParam("project") String project, @RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate, @RequestParam("priority") int priority, @RequestParam("manager") String manager) {
		Project projectpojo = new Project();
		String response="";
		
		projectpojo.setProject(project);
		projectpojo.setStartDate(startdate);
		projectpojo.setEndDate(enddate);
		projectpojo.setPriority(priority);
		projectpojo.setIsCompleted("0");
		
		
		
		Project insertedProject = projectService.addProject(projectpojo);
		userService.updateProjectId(insertedProject.getProjectId(), manager);
		
		
		return insertedProject;
		

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getProject", method = RequestMethod.GET)
	public List<Project> getProject()
	{
		List<Project> projectList = projectService.getAllProject();
		return projectList;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updateProject", method = RequestMethod.POST)
	public Project updateProject(@RequestParam("project") String project, @RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate, @RequestParam("priority") int priority) {
		Project projectpojo = new Project();
		String response="";
		
		projectpojo.setProject(project);
		projectpojo.setStartDate(startdate);
		projectpojo.setEndDate(enddate);
		projectpojo.setPriority(priority);
		projectpojo.setCount(0);
		
		
		
		
		Project insertedProject = projectService.updateProject(projectpojo);
		
		
		return insertedProject;
		

	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getProjectTask", method = RequestMethod.POST)
	public List<Task> getUserTasks(@RequestParam("project") String project) {
		int p = projectService.getprojectId(project);
		
		List<Task> t = operate.getTaskbyProject(p);
		return t;
	}
		
		
		


	

}
