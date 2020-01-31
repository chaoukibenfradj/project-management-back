package com.jihene.parc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihene.parc.model.dao.taskRepository;
import com.jihene.parc.model.entity.Projet;
import com.jihene.parc.model.entity.Task;
import com.jihene.parc.modele.security.User;
import com.jihene.parc.security.repository.UserRepository;

@Service
public class TaskService implements TaskServiceInterface {

	@Autowired
	private taskRepository taskRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ServiceProjet projectService;

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task findTask(String id) {
		return taskRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public Task updateTask(Task task) {
		Projet taskProject = projectService.findProject(String.valueOf(task.getProjet().getId()));
		User userProject = userRepo.findById(task.getUser().getId()).get();
		task.setUser(userProject);
		task.setProjet(taskProject);
		return taskRepo.save(task);
	}

	@Override
	public void deleteTask(String id) {
		taskRepo.deleteById(Long.parseLong(id));
	}

	@Override
	public Task addTask(Task task) {
		Projet taskProject = projectService.findProject(String.valueOf(task.getProjet().getId()));
		User userProject = userRepo.findById(task.getUser().getId()).get();
		task.setUser(userProject);
		task.setProjet(taskProject);
		return taskRepo.save(task);
	}

	@Override
	public List<Task> findTaskByProjectId(String id) {
		return taskRepo.findAll().stream().filter(element -> String.valueOf(element.getProjet().getId()).equals(id))
				.collect(Collectors.toList());

	}

	@Override
	public List<Task> findTasksByUserId(String id) {
		
		return taskRepo.findAll()
				.stream()
				.filter(element-> String.valueOf(element.getUser().getId()).equals(id))
				.collect(Collectors.toList());
	}

}
