package com.example.springboot.requestMapping.springbootrequestdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/shortcuts")
//@RequestMapping Shortcuts
public class RequestMappingShortcutsController {
	@GetMapping("/person")
	public @ResponseBody ResponseEntity<String> getPerson() {
		return new ResponseEntity<String>("Response from GET", HttpStatus.OK);
	}

	/**
	 * @GetMapping is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method =RequestMethod.GET).
	 * @param id
	 * @return
	 */
	@GetMapping("/person/{id}")
	public @ResponseBody ResponseEntity<String> getPersonById(@PathVariable String id) {
		return new ResponseEntity<String>("Response from GET with id " + id, HttpStatus.OK);
	}

	@PostMapping("/person")
	public @ResponseBody ResponseEntity<String> postPerson() {
		return new ResponseEntity<String>("Response from POST method", HttpStatus.OK);
	}

	@PutMapping("/person")
	public @ResponseBody ResponseEntity<String> putPerson() {
		return new ResponseEntity<String>("Response from PUT method", HttpStatus.OK);
	}

	@DeleteMapping("/person")
	public @ResponseBody ResponseEntity<String> deletePerson() {
		return new ResponseEntity<String>("Response from DELETE method", HttpStatus.OK);
	}

	@PatchMapping("/person")
	public @ResponseBody ResponseEntity<String> patchPerson() {
		return new ResponseEntity<String>("Response from PATCH method", HttpStatus.OK);
	}
}
