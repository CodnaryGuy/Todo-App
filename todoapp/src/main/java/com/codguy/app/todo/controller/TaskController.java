package com.codguy.app.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codguy.app.todo.models.Task;

import jakarta.websocket.server.PathParam;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService; 
	}
	
	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@PostMapping
	public String createTasks(@RequestParam String title) {
		taskService.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String getTasks(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		taskService.toggleTask(id);
		return "redirect:/";
	}
	
}