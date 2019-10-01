package com.capsule.taskmanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.taskmanager.model.Project;
import com.capsule.taskmanager.model.Task;
import com.capsule.taskmanager.model.Users;
import com.capsule.taskmanager.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository<Project> repo;
	
	@Autowired
	UsersService userService;

	@Transactional
	public Project addProject(Project projectpojo) {
			return repo.save(projectpojo);		
	}

	@Transactional
	public List<Project> getAllProject() {
			List<Project> pList= (List<Project>) repo.findAll();
			List<Project> updatedList = new ArrayList<Project>();
		for(Project p: pList)
		{
			Project pro = new Project();
			pro.setProject(p.getProject());
			pro.setCount(getCount(p.getProjectId()));
			pro.setStartDate(p.getStartDate());
			pro.setEndDate(p.getEndDate());
			pro.setIsCompleted(p.getIsCompleted().equals("0") ? "No" : "Yes");
			pro.setPriority(p.getPriority());
			updatedList.add(pro);
			
		}
		return updatedList;
	}

	private int getCount(int projectId) {
		
		return userService.getTaskCount(projectId);
	}

	public Project updateProject(Project projectpojo) {
		Project existingProject = repo.findByproject(projectpojo.getProject());
		
		existingProject.setCount(0);
		existingProject .setEndDate(projectpojo.getEndDate());
		existingProject.setStartDate(projectpojo.getStartDate());
		existingProject.setIsCompleted(existingProject.getIsCompleted());
		existingProject.setPriority(projectpojo.getPriority());
		existingProject.setProjectId(existingProject.getProjectId());
		existingProject.setProject(projectpojo.getProject());
		
		Project updatedProject = repo.save(existingProject);
		// TODO Auto-generated method stub
		return updatedProject;
	}

	public int getprojectId(String project) {
		Project existingProject = repo.findByproject(project);
		return existingProject.getProjectId();
	}

}
