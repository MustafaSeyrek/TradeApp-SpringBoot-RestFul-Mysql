package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.User;
import com.example.app.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/hepsi")
	public List<User> list() {
		return service.listAll();
	}

	@PostMapping("/ekle")
	public void add(@RequestBody User user) {
		service.createUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteUser(id);
	}
}
