package com.example.webstore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.webstore.models.User;
import com.example.webstore.services.UserService;


/**
 * handles mappings for users
 * @author JB
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * Interacts with the database
	 */
	@Autowired
	private UserService userService;

	/**
	 * Shows 
	 * @param model what stores what we put on the website
	 * @return the html page to go to (users.html)
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<User> user = userService.getAll();

		model.addAttribute("user", user);
		return "user";
	}
	
	/**
	 * Adds new user to the database
	 * @param user the user to add
	 * @return the html page to go to (users.html)
	 */
	@PostMapping("/addNew")
	public String addNew(User user) {
		userService.addNew(user); //adds user to user table
		return "redirect:/user/getAll"; //redirects back to all the results
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.update(user);
		return "redirect:/user/getAll"; //redirects back to all the results
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<User> getOne(Integer bookid) {
		return userService.getOne(bookid);
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer bookid) {
		userService.delete(bookid);
		
		return "redirect:/user/getAll";
	}
}
