package com.example.actuator.actuatordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.actuator.actuatordemo.service.SampleService;

@SpringBootApplication
public class ActuatorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorDemoApplication.class, args);
	}

	@Bean
	public SampleService sampleService() {

		return new SampleService("Testing2");
	}

}
