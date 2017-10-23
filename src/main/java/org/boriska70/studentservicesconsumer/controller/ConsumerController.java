package org.boriska70.studentservicesconsumer.controller;

import org.boriska70.studentservicesconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;

	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Hello " + name;
		
	}
	
	@GetMapping("/students/all")
	public ResponseEntity<String> getAllStudents() {

		ResponseEntity<String> resp = consumerService.getAllSudents();
		if (resp.getStatusCodeValue() == 200) {
			System.out.println("Cool! We succeeded to get all students");
			return resp;
		} else {
			System.out.println("Bad! We failed to get all students and status code is " + resp.getStatusCodeValue());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something bad happened...");
		}
	}

}
