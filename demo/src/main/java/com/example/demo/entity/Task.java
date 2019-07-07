package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task_table")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="task_id")
	int task_id;
	
	@Column(name="parent_id")
	int parent_id;
	
	@Column(name="task")
	String task;
	
	@Column(name = "start_date")
	String start_date;
	
	@Column(name = "end_date")
	String end_date;
	
	@Column(name="priority")
	int priority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id",insertable = false, updatable = false)
	ParentTask parentTask;
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public Task(int task_id, int parent_id, String task, String start_date,
	 * String end_date, int priority) { super(); this.task_id = task_id;
	 * this.parent_id = parent_id; this.task = task; this.start_date = start_date;
	 * this.end_date = end_date; this.priority = priority; }
	 */
	
	
	public Task(int id, int task_id, int parent_id, String task, String start_date, String end_date, int priority,
			ParentTask parentTask) {
		super();
		this.id = id;
		this.task_id = task_id;
		this.parent_id = parent_id;
		this.task = task;
		this.start_date = start_date;
		this.end_date = end_date;
		this.priority = priority;
		this.parentTask = parentTask;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ParentTask getParentTask() {
		return parentTask;
	}
	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}
	
	
	
}
