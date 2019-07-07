package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITaskDao;
import com.example.demo.entity.ParentTask;
import com.example.demo.entity.Task;
import com.example.demo.entity.TaskList;
import com.example.demo.entity.TaskManager;
@Service
public class TaskService implements ITaskService{

	@Autowired
	private ITaskDao taskDAO;
	@Override
	public List<TaskManager> getAllTasks() {
		
		
		
		List<TaskManager> tlist = new ArrayList<>();
		
		List<Task> t = taskDAO.getAllTasks();
		
		for(Task task : t) {
			TaskManager tm = new TaskManager();
			
			tm.setParentTaskid(task.getParent_id());
			tm.setPtaskName(String.valueOf(task.getParent_id()));
			tm.setTask(task.getTask());
			tm.setStart_date(task.getStart_date() );
			tm.setEnd_date(task.getEnd_date());
			tm.setPriority(task.getPriority());
			
			tlist.add(tm);
		}
		
		return tlist;
	}

	@Override
	public TaskManager getTaskById(int taskId) {
		Task task = taskDAO.getTaskById(taskId);
		
		TaskManager tm = new TaskManager();
		
		tm.setParentTaskid(task.getParent_id());
		tm.setPtaskName(String.valueOf(task.getParent_id()));
		tm.setTask(task.getTask());
		tm.setStart_date(task.getStart_date() );
		tm.setEnd_date(task.getEnd_date());
		tm.setPriority(task.getPriority());
	return tm;
	}

	@Override
	public void addTask(ParentTask parentTask) {
		taskDAO.addTask(parentTask);
		
	}

	@Override
	public void updateTask(ParentTask task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(int pid, int taskId) {
		taskDAO.deleteTask(pid, taskId);
		
	}

	


	
}
