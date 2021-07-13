package com.example.webstore.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstore.models.User;
import com.example.webstore.repositories.UserRepository;
/**
 * Lets the application retrieve and add to MySQL Database
 * @author JB
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public void addNew(User user) {
		userRepository.save(user);
	}
	
	public void update(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> getOne(Integer bookid) {
		return userRepository.findById(bookid);
	}
	
	public void delete(Integer bookid) {
		userRepository.deleteById(bookid);
	}
}
