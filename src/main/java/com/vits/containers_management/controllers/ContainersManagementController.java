package com.vits.containers_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Container;
import com.vits.containers_management.services.DockerService;

@RestController
@RequestMapping("/api/containers")
public class ContainersManagementController {
	private final DockerService dockerService;
	
	public ContainersManagementController(DockerService dockerService) {
		this.dockerService = dockerService;
	}
	
	@GetMapping()
	public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") Boolean showAll) {
		return dockerService.listContainers(showAll);
	}
	
	@PostMapping("/start/{id}")
	public void startContainer(@PathVariable String id) {
		dockerService.startContainer(id);
	}
	
	@PostMapping("/stop/{id}")
	public void stopContainer(@PathVariable String id) {
		dockerService.startContainer(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteContainer(@PathVariable String id) {
		dockerService.deleteContainer(id);
	}

	@PostMapping("/create")
	public void createContainer(@RequestParam(required = true) String imageName) {
		dockerService.startContainer(imageName);
	}
}
