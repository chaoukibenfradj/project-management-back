package com.jihene.parc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jihene.parc.model.entity.Task;
import com.jihene.parc.services.TaskService;

@RestController
@RequestMapping(value = "/admin")
@CrossOrigin(origins = "*")
public class taskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/task", method = RequestMethod.POST)
	Task addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}

	@RequestMapping(value = "/task", method = RequestMethod.PUT)
	Task updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}

	@RequestMapping(value = "/task/projet/{id}", method = RequestMethod.GET)
	List<Task> getTasksByProjectId(@PathVariable String id) {
		return taskService.findTaskByProjectId(id);
	}

	@RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
	Task getTasksById(@PathVariable String id) {
		return taskService.findTask(id);
	}

	@RequestMapping(value = "/task/user/{id}", method = RequestMethod.GET)
	List<Task> getTasksByUserId(@PathVariable String id) {
		return taskService.findTasksByUserId(id);
	}

	@RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
	void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}

}
