package com.example.springboot.requestMapping.springbootrequestdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/test")
//The params element of the @RequestMapping annotation
//further helps to narrow down request mapping.
public class RequestMappingWithRequestParametersController {
	@RequestMapping(value = "/fetch", params = { "personId=10" })
	String getParams(@RequestParam("personId") String id) {
		return "Fetched parameter using params attribute = " + id;
	}

	@RequestMapping(value = "/fetch", params = { "personId=20" })
	String getParamsDifferent(@RequestParam("personId") String id) {
		return "Fetched parameter using params attribute = " + id;
	}

	// The @RequestMapping annotation provides a header element to narrow down the
	// request mapping
	@RequestMapping(value = "/head", headers = { "content-type=text/plain" })
	String post() {
		return "Mapping applied along with headers";
	}

	/**
	 * In order to produce the object in the requested media type, you use the
	 * produces element of
	 * 
	 * @RequestMapping in combination with the @ResponseBody annotation.
	 * @return
	 */
	@RequestMapping(value = "/prod", produces = { "application/JSON" })
	@ResponseBody
	String getProduces() {
		return "Produces attribute";
	}

	/**
	 * You can also consume the object with the requested media type using the
	 * consumes element of@RequestMapping in combination with the @RequestBody
	 * annotation.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cons", consumes = { "application/JSON", "application/XML" })
	String getConsumes() {
		return "Consumes attribute";
	}
}
