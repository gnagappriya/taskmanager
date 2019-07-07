package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ParentTask;
import com.example.demo.entity.Task;
import com.example.demo.entity.TaskManager;

public interface ITaskService {
	/*
	 * List<Task> getAllTasks(); Task getTaskById(int taskId); void addTask(Task
	 * task); void updateTask(Task task); void deleteTask(int taskId);
	 */
     
     
     List<TaskManager> getAllTasks();
     TaskManager getTaskById(int taskId);
     void addTask(ParentTask parentTask);
     void updateTask(ParentTask task);
     void deleteTask(int pid, int taskId);
}
