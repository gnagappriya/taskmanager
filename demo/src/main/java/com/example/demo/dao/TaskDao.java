package com.example.demo.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ParentTask;
import com.example.demo.entity.Task;
import com.example.demo.entity.TaskManager;
@Transactional
@Repository
public class TaskDao implements ITaskDao {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		String hql = "FROM Task as atcl ORDER BY atcl.task_id";
		return (List<Task>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Task getTaskById(int taskId) {
		/*
		 * ParentTask p = entityManager.find(ParentTask.class, taskId); Task t =
		 * entityManager.find(Task.class, taskId); Set<Task> taskset = new HashSet<>();
		 * taskset.add(t); p.setTaskSet(taskset);
		 */
		
		return  entityManager.find(Task.class, taskId);
	}

	@Override
	public void addTask(ParentTask parentTask) {
		entityManager.persist(parentTask);
		Iterator i = parentTask.getTaskSet().iterator();
		while(i.hasNext()) {
			Task t =  (Task)i.next();
			t.setParent_id(parentTask.getParentId());
			entityManager.persist(t);
		}
		
		
		
	}

	@Override
	public void updateTask(ParentTask task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(int pid,int taskId) {
		entityManager.remove(fetchTaskById(pid, taskId));
		
	}
	public Task fetchTaskById(int pid, int tid){
		String jpql = "from Task t where t.parent_id = :pid and t.task_id = :tid";
		List<Task> t = 
				entityManager.createQuery(jpql, Task.class)
		      .setParameter("pid", pid)
		      .setParameter("tid", tid)
		      .getResultList();

		return (Task) t.get(0);


	}
	
	

}
