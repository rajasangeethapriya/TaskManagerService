package com.capsule.taskmanager.repository;
import com.capsule.taskmanager.model.Task;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaskRepository<T> extends CrudRepository<Task, Long> {

	Task findBytask(String task);

}
