package com.capsule.taskmanager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.taskmanager.model.Task;
import com.capsule.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository<Task> repo;
	
	@Transactional
	public boolean addTask(Task task)
	{
		return repo.save(task) != null;
		
	}

	@Transactional
	public List<Task> getallTask() {
		return (List<Task>) repo.findAll();
	}

	@Transactional
	public Task updateTask(Task t) {
		
		Task existingTask = repo.findBytask(t.getTask());
		
		existingTask.setParentTask(t.getParentTask());
		existingTask.setPriority(t.getPriority());
		existingTask.setStartDate(t.getStartDate());
		existingTask.setEndDate(t.getEndDate());
		existingTask.setEndFlag(t.getEndFlag());
		
		Task updatedTask = repo.save(existingTask);
		return updatedTask;
		
	}

	

}
