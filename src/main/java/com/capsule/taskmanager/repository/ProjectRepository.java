package com.capsule.taskmanager.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capsule.taskmanager.model.Project;

public interface ProjectRepository<T> extends CrudRepository<Project, Long> {

	Project findByproject(String project);
	

	

}
