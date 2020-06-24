package com.example.demo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class SpringCloudStreamKafkaLocationProducerApplication {
	
	@Autowired
	private MessageChannel output;
	
	@PostMapping("/publish-user-location")
	public Location sendLocation(@RequestBody Location location) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		location.setTimeStamp(timestamp);
		
		output.send(MessageBuilder.withPayload(location).build());
		
		return location;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaLocationProducerApplication.class, args);
	}

}
