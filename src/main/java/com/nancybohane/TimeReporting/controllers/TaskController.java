package com.nancybohane.TimeReporting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nancybohane.TimeReporting.models.Task;
import com.nancybohane.TimeReporting.models.User;
import com.nancybohane.TimeReporting.repositories.TaskRepository;



@Controller
@CrossOrigin
@RequestMapping(path = "/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Task createTask(@RequestBody Task task){
		return taskRepository.save(task);
	}
	
	// Read all
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// Read by ID
	@GetMapping(path = "")
	public @ResponseBody Task getTaskById(@RequestParam int id) {
		return taskRepository.findById(id).get();
	}

	// Update
	@PutMapping(path = "")
	public @ResponseBody String updateTask(@RequestBody Task task) {
		taskRepository.save(task);
		return "Task Updated Successfully!";
	}
	
	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteTask(@RequestParam int id) throws Exception {
		try {
			taskRepository.deleteById(id);
			return "Deleted task!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete task: " + id);
	}

}
