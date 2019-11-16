package com.example.actuator.actuatordemo.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.actuator.actuatordemo.service.SampleService;

@RestController
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@GetMapping("/")
	public String sayHello() {
		return sampleService.printMsg();
	}

	@GetMapping("/slowApi")
	public String timeConsumingAPI(@RequestParam(value = "delay", defaultValue = "0") Integer delay)
			throws InterruptedException {
		if (delay == 0) {
			Random random = new Random();
			delay = random.nextInt(10);
		}

		TimeUnit.SECONDS.sleep(delay);
		return "Result";
	}
}