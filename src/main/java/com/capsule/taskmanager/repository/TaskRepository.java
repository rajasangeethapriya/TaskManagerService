package com.capsule.taskmanager.repository;
import com.capsule.taskmanager.model.Task;
import com.capsule.taskmanager.model.Users;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaskRepository<T> extends CrudRepository<Task, Long> {

	Task findBytask(String task);

	List<Task> findBytaskid(int userid);

	

}
