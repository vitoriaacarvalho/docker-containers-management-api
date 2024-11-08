package com.vits.containers_management.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Image;
import com.vits.containers_management.services.DockerService;

@RestController
@RequestMapping("api/images")
public class ImagesManagerController {
	
	private final DockerService dockerService;
	
	public ImagesManagerController(DockerService dockerService) {
		this.dockerService = dockerService;
	}
	
	@GetMapping("/all-images")
	public List<Image> listImages() {
		return dockerService.listImages();
	}
	
	@GetMapping("/filter-by-name")
	public List<Image> listImages(@RequestParam(required = true) String imageName) {
		return dockerService.listImagesByName(imageName);
	}
	
}
