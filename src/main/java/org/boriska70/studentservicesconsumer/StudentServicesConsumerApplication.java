package org.boriska70.studentservicesconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentServicesConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServicesConsumerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder rtb) {
		return rtb.build();
	}
		
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws RestClientException{
		return (args) -> {
			String result = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
			ResponseEntity<String> result2 = restTemplate.getForEntity("http://gturnquist-quoters.cfapps.io/api/random", String.class);
			System.out.println(result);
			HttpStatus status = result2.getStatusCode();
			String body = result2.getBody();
			System.out.println(String.format("Status: %d for message: %s", status.value(), body));
		};
	}
	
}
