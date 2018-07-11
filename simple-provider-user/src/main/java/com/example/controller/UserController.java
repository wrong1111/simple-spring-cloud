package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dao.UserRepository;
import com.example.model.User;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/user")
	public User findById(@RequestParam Integer id) {
		User findOne = this.userRepository.findOne(id);
		return findOne;
	}
}
