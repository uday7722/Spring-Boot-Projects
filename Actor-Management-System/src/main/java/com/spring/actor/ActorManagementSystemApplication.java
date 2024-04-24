package com.spring.actor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.actor.controller.ActorController;
import com.spring.actor.entity.Actor;

@SpringBootApplication
public class ActorManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActorManagementSystemApplication.class, args);


	}


}
