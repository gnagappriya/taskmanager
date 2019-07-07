package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parent_task_table")
public class ParentTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parent_id")
	int parentId;
	
	@Column(name="parent_task")
	String parent_task;
	
	@OneToMany(mappedBy = "parentTask",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
	Set<Task> taskSet;
	
	

	public ParentTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParentTask(int parentId, String parent_task, Set<Task> taskSet) {
		super();
		this.parentId = parentId;
		this.parent_task = parent_task;
		this.taskSet = taskSet;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParent_task() {
		return parent_task;
	}

	public void setParent_task(String parent_task) {
		this.parent_task = parent_task;
	}

	public Set<Task> getTaskSet() {
		return taskSet;
	}

	public void setTaskSet(Set<Task> taskSet) {
		this.taskSet = taskSet;
	}
	
	

}
