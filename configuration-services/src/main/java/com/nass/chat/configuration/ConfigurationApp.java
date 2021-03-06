package com.nass.chat.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationApp {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApp.class, args);
	}
}
