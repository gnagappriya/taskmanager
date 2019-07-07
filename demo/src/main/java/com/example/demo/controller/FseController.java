package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.ParentTask;
import com.example.demo.entity.Task;
import com.example.demo.entity.TaskManager;
import com.example.demo.service.ITaskService;

@RestController
@RequestMapping("task")
public class FseController {

	@Autowired
	private ITaskService tasksService;

	@GetMapping("add/{id}")
	public ResponseEntity<String> test(@PathVariable("id") Integer id) {
		// Article article = articleService.getArticleById(id);
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}

	@GetMapping("task/{id}")
	public ResponseEntity<TaskManager> getTaskById(@PathVariable("id") Integer id) {
		
		TaskManager tm = tasksService.getTaskById(id);
		
		return new ResponseEntity<TaskManager>(tm, HttpStatus.OK);
	}

	@GetMapping("getAllTasks")
	public ResponseEntity<List<TaskManager>> getAllTasks() {
		List<TaskManager> taskList = tasksService.getAllTasks();
		return new ResponseEntity<List<TaskManager>>(taskList, HttpStatus.OK);
	}
	
	@DeleteMapping("end/{pid}/{tid}")
	public ResponseEntity<List<TaskManager>> endTask(@PathVariable("pid") Integer pid, @PathVariable("tid") Integer tid) {
		tasksService.deleteTask(pid, tid);
		List<TaskManager> taskList = tasksService.getAllTasks();
		
		return new ResponseEntity<List<TaskManager>>(taskList, HttpStatus.OK);
	}

	@PostMapping("addTask")
	public ResponseEntity<ParentTask> addTasks(@RequestBody TaskManager taskManager, UriComponentsBuilder builder) {
		
		ParentTask parentTask =  new ParentTask();
		Task t =new Task();
		t.setParent_id(taskManager.getParentTaskid());
		t.setTask_id(taskManager.getTask_id());
		t.setTask(taskManager.getTask());
		t.setStart_date(taskManager.getStart_date());
		t.setEnd_date(taskManager.getEnd_date());
		t.setPriority(taskManager.getPriority());
		
		Set<Task> taskSet =new HashSet<>();
		taskSet.add(t);
		parentTask.setParent_task(String.valueOf(t.getParent_id()));
		parentTask.setTaskSet(taskSet);
		tasksService.addTask(parentTask);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/task/{id}").buildAndExpand(parentTask.getParentId()).toUri());
		return new ResponseEntity<ParentTask>(parentTask, HttpStatus.CREATED);
	}
}
