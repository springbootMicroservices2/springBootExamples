package com.example.springboot.adminserver.springbootadmindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringbootAdminDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAdminDemoApplication.class, args);
	}

}
