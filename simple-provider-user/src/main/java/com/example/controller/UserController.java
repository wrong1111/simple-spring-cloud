package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dao.UserRepository;
import com.example.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/find")
	public User findById(@RequestParam Integer id) {
		User findOne = this.userRepository.findOne(id);
		return findOne;
	}

	@GetMapping("/find/{id}")
    public User findByUserId(@PathVariable(value="id") Integer id){
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }
}
