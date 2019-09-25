package com.capsule.taskmanager.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@Column(name="projectid")
	int projectId;
	
	@Column(name="project")
	String project;
	
	@Column(name="startdate")
	String StartDate;
	
	@Column(name="enddate")
	String endDate;
	
	@Column(name="priority")
	int priority;
	
	@Column(name="isCompleted")
	String isCompleted;
	
	@Column(name="count")
	int count;
	
	

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startdate2) {
		StartDate = startdate2;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String enddate2) {
		this.endDate = enddate2;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", project=" + project + ", StartDate=" + StartDate + ", endDate="
				+ endDate + ", priority=" + priority + ", isCompleted=" + isCompleted + ", count=" + count + "]";
	}


	
	
	
	

}
