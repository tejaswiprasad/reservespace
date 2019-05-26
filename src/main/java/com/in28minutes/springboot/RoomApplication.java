package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mrbs.controller.RoomController;


@SpringBootApplication
@ComponentScan(basePackages = {"com.mrbs.controller","com.mrbs.service"})
@EntityScan("com.mrbs.model")
@EnableJpaRepositories("com.mrbs.jpa")
public class RoomApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(
				RoomApplication.class, args);
		//System.out.println(ctx);
	}
}