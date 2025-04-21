package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		if (user.getAge() == null || user.getCountry() == null) {
			throw new IllegalArgumentException("Age and country are required.");
		}

		if (user.getAge() < 18 || !"France".equalsIgnoreCase(user.getCountry())) {
			throw new IllegalArgumentException("Only adults (18+) from France can register.");
		}

		return userRepository.save(user);
	}

	public Optional<User> getUserById(String id) {
		return userRepository.findById(id);
	}

}
