package org.boriska70.studentservicesconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<String> getAllSudents() {
		String url = "http://localhost:8080/sb/students/";
		try {
		ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
		System.out.println("Got response for getAllStudents, status is " + resp.getStatusCode().name());
		return resp;
		} catch (RestClientException rce) {
			System.out.println("Failed to get all students: " + rce.getMessage());
			return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	

}
