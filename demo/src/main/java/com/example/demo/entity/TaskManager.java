package com.example.demo.entity;

import java.util.List;

public class TaskManager {

	int parentTaskid;
	
	String ptaskName;

	int task_id;

	String task;

	String start_date;

	String end_date;

	int priority;

	

	public int getParentTaskid() {
		return parentTaskid;
	}

	public void setParentTaskid(int parentTaskid) {
		this.parentTaskid = parentTaskid;
	}

	public String getPtaskName() {
		return ptaskName;
	}

	public void setPtaskName(String ptaskName) {
		this.ptaskName = ptaskName;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
