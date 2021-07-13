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

import com.example.webstore.models.Department;
import com.example.webstore.services.DepartmentService;

/**
 * handles mappings for departments
 * @author JB
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	/**
	 * Interacts with the database
	 */
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * Shows 
	 * @param model what stores what we put on the website
	 * @return the html page to go to (departments.html)
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Department> department = departmentService.getAll();

		model.addAttribute("department", department);
		return "department";
	}
	
	/**
	 * Adds new department to the database
	 * @param department the department to add
	 * @return the html page to go to (departments.html)
	 */
	@PostMapping("/addNew")
	public String addNew(Department department) {
		departmentService.addNew(department); //adds department to department table
		return "redirect:/department/getAll"; //redirects back to all the results
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Department department) {
		departmentService.update(department);
		return "redirect:/department/getAll"; //redirects back to all the results
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Department> getOne(Integer bookid) {
		return departmentService.getOne(bookid);
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer bookid) {
		departmentService.delete(bookid);
		
		return "redirect:/department/getAll";
	}
}
