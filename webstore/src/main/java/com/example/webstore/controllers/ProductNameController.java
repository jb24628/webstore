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

import com.example.webstore.models.ProductName;
import com.example.webstore.services.ProductNameService;

/**
 * handles mappings for productNames
 * @author JB
 *
 */
@Controller
@RequestMapping("/productName")
public class ProductNameController {
	/**
	 * Interacts with the database
	 */
	@Autowired
	private ProductNameService productNameService;

	/**
	 * Shows 
	 * @param model what stores what we put on the website
	 * @return the html page to go to (productNames.html)
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<ProductName> productName = productNameService.getAll();
		
		model.addAttribute("productName", productName);
		return "productName";
	}
	
	/**
	 * Adds new productName to the database
	 * @param productName the productName to add
	 * @return the html page to go to (productNames.html)
	 */
	@PostMapping("/addNew")
	public String addNew(ProductName productName) {
		productNameService.addNew(productName); //adds productName to productName table
		return "redirect:/productName/getAll"; //redirects back to all the results
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(ProductName productName) {
		productNameService.update(productName);
		return "redirect:/productName/getAll"; //redirects back to all the results
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<ProductName> getOne(Integer bookid) {
		return productNameService.getOne(bookid);
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer bookid) {
		productNameService.delete(bookid);
		
		return "redirect:/productName/getAll";
	}
}
