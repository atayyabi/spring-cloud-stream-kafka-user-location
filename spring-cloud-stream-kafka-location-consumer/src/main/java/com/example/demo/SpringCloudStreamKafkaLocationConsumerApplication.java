package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.example.demo")
@EnableBinding(Sink.class)
public class SpringCloudStreamKafkaLocationConsumerApplication {
	
	
	private Logger logger = LoggerFactory.getLogger(SpringCloudStreamKafkaLocationConsumerApplication.class);
	
	@StreamListener("input")
	public void consumeUserLocation(Location location) {
		
		logger.info("Consume payload: " + location);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaLocationConsumerApplication.class, args);
	}

}
