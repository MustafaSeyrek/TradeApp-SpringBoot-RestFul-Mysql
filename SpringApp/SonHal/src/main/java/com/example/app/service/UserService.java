package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> listAll() {
		return repository.findAll();
	}

	public void createUser(User user) {
		repository.save(user);
	}

	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}
}
