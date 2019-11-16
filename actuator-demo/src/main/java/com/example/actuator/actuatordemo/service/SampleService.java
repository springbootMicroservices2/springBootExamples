package com.example.actuator.actuatordemo.service;

public class SampleService {

	private String msg;

	public SampleService(String msg) {
		super();
		this.msg = msg;
	}

	public String printMsg() {
		return this.msg;
	}

}
