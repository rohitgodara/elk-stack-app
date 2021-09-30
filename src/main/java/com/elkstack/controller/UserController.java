package com.elkstack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	Map<Integer, String> users = new HashMap<>();

	@PostConstruct
	public void initMap() {
		users.put(1, "Rohit Godara");
		users.put(2, "Ritu Bhutra");
		users.put(3, "Divya Joshi");
		users.put(4, "Akshay Sharma");

	}

	@GetMapping("{id}")
	public String findById(@PathVariable int id) {
		String name = users.get(id);
		if (name != null) {
			LOGGER.info("User name found for id :::::::::  {id} :: is :: {name}");
			return name;
		}
		LOGGER.info("No user name found for id ::::::::: ", id);
		return null;
	}
}
