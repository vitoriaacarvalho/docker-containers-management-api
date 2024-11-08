package com.vits.containers_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;

@Configuration
public class DockerClientConfig {
	
	@Bean
	public DockerClient buildDockerClient() {
		DefaultDockerClientConfig dockerClientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
		        .withDockerHost("tcp://localhost:2375") 
		        .build();

        ApacheDockerHttpClient dockerHttpClient = new ApacheDockerHttpClient.Builder()
        		.dockerHost(dockerClientConfig.getDockerHost()).build();
        
		return DockerClientBuilder.getInstance(dockerClientConfig)
				.withDockerHttpClient(dockerHttpClient)
				.build();
	}
}
