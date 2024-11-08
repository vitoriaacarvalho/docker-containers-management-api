package com.vits.containers_management.services;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;

@Service
public class DockerService {
	private final DockerClient dockerClient;
	
	public DockerService(DockerClient client) {
		this.dockerClient = client;
	}
}
