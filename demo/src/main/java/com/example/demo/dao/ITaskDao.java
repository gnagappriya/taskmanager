package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ParentTask;
import com.example.demo.entity.Task;

public interface ITaskDao {
	
	/*
	 * List<Task> getAllTasks(); Task getTaskById(int taskId); void addTask(Task
	 * taskId); void updateTask(Task taskId); void deleteTask(int taskId);
	 */
	
	List<Task> getAllTasks();
	Task getTaskById(int taskId);
    void addTask(ParentTask parentTask);
    void updateTask(ParentTask task);
    void deleteTask(int pid,int parentTaskId);
}
