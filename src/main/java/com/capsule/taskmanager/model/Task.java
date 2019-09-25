package com.capsule.taskmanager.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Task {
	
	
	@Column(name="task")
	private String task;
	
	@Column(name="parenttask")
	private String ParentTask;
	
	@Column(name="priority")
	private int Priority;
	
	@Column(name="startdate")
	private Date StartDate;
	
	@Column(name="enddate")
	private Date EndDate;
	
	@Column(name="endFlag")
	private int endFlag;
	
	@Id
	@GeneratedValue
	@Column(name="taskid")
	private int taskid;
	
	@Column(name="projectid")
	private int projectid;
	
	public Task() {}

	

	public String getTask() {
		return task;
	}



	public void setTask(String task) {
		this.task = task;
	}



	public String getParentTask() {
		return ParentTask;
	}

	public void setParentTask(String parentTask) {
		ParentTask = parentTask;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	





	public int getTaskid() {
		return taskid;
	}



	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}



	public int getProjectid() {
		return projectid;
	}



	public void setProjectid(int i) {
		this.projectid = i;
	}



	





	public Task(String task, String parentTask, int priority, Date startDate, Date endDate, int endFlag, int taskid,
			int projectid) {
		super();
		this.task = task;
		ParentTask = parentTask;
		Priority = priority;
		StartDate = startDate;
		EndDate = endDate;
		this.endFlag = endFlag;
		this.taskid = taskid;
		this.projectid = projectid;
	}



	public int getEndFlag() {
		return endFlag;
	}



	public void setEndFlag(int endFlag) {
		this.endFlag = endFlag;
	}



	@Override
	public String toString() {
		return "Task [task=" + task + ", ParentTask=" + ParentTask + ", Priority=" + Priority + ", StartDate="
				+ StartDate + ", EndDate=" + EndDate + ", endFlag=" + endFlag + ", testid=" + taskid + ", projectid="
				+ projectid + "]";
	}



	



	
	
	
	
	
	

}