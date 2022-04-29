package br.com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.service.TaskService;

@RestController
@RequestMapping("/api/tasks/")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping("{youtubeChannelId}")
	public String createTask(@PathVariable String youtubeChannelId ) {
		return service.createTask(youtubeChannelId);
	}

}
