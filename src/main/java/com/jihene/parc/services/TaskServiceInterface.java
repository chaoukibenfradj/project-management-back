package com.jihene.parc.services;

import java.util.List;

import com.jihene.parc.model.entity.Projet;
import com.jihene.parc.model.entity.Task;

public interface TaskServiceInterface {
 	List<Task> findTasksByUserId(String id) ;
	Task addTask(Task task);
	List findAll();
    Task findTask(String id);
    Task updateTask(Task task);
    void deleteTask(String id) ; 
    List<Task> findTaskByProjectId(String id) ; 
}
