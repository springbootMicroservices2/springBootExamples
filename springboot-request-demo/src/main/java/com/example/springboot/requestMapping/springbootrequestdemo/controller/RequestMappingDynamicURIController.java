package com.example.springboot.requestMapping.springbootrequestdemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/dynamic")
public class RequestMappingDynamicURIController {

	/**
	 * The @RequestMapping annotation is used in combination with the @PathVaraible
	 * annotation to handle dynamic URIs
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
	String getDynamicUriValue(@PathVariable String id) {
		System.out.println("ID is " + id);
		return "Dynamic URI parameter fetched";
	}

	/**
	 * You can also use regular expressions to only accept the dynamic URI values
	 * that match the regular expression.
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
	String getDynamicUriValueRegex(@PathVariable("name") String name) {
		System.out.println("Name is " + name);
		return "Dynamic URI parameter fetched using regex";
	}
}
