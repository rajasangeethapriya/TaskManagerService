package com.capsule.taskmanager.controller;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capsule.taskmanager.model.Task;
import com.capsule.taskmanager.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class, secure = false)
public class TaskControllerTest {/*
	
	@Autowired 
	MockMvc mockmvc;
	
	@MockBean
	private TaskService taskService;
	
	//Task mockTask = new Task ("T1", "PT1", 1, new Date(1, 9, 2019), new Date(1, 9, 2019));
	

	@Test
	@Ignore
	public void getTask() throws Exception {
		Mockito.when(
				taskService.getallTask()).thenReturn((List<Task>) mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(null).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{task:T1,parentTask:PT1,startDate:01/09/2019,EndDate:01/09/2019}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	@Ignore

	public void add() throws Exception {
		Mockito.when(
				taskService.addTask(mockTask)).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(null).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{task:T1,parentTask:PT1,startDate:01/09/2019,EndDate:01/09/2019}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	@Ignore

	public void update() throws Exception {
		Mockito.when(
				taskService.updateTask(mockTask)).thenReturn( mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(null).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{task:T1,parentTask:PT1,startDate:01/09/2019,EndDate:01/09/2019}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

*/}
