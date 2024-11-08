package com.vits.containers_management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

@Service
public class DockerService {
	private final DockerClient dockerClient;
	
	public DockerService(DockerClient client) {
		this.dockerClient = client;
	}
	
	public List<Container> listContainers(Boolean all) {
		return dockerClient.listContainersCmd().withShowAll(all).exec();
	}
	
	public List<Image> listImages(){
		return dockerClient.listImagesCmd().exec();
	}
	
	public List<Image> listImagesByName(String filterByName){
		return dockerClient.listImagesCmd().withImageNameFilter(filterByName).exec();
	}
	
	public void startContainer(String containerId) {
		dockerClient.startContainerCmd(containerId).exec();
	}
	
	public void stopContainer(String containerId) {
		dockerClient.stopContainerCmd(containerId);
	}
	
	public void deleteContainer(String containerId) {
		dockerClient.removeContainerCmd(containerId).exec();
	}
	
	public void createContainer(String imageName) {
		dockerClient.createContainerCmd(imageName).exec();
	}
}
