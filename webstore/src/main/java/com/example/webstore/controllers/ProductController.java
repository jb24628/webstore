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

import com.example.webstore.models.Product;
import com.example.webstore.services.ProductService;

/**
 * handles mappings for products
 * @author JB
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	/**
	 * Interacts with the database
	 */
	@Autowired
	private ProductService productService;

	/**
	 * Shows 
	 * @param model what stores what we put on the website
	 * @return the html page to go to (products.html)
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Product> product = productService.getAll();
		
		model.addAttribute("product", product);
		return "product";
	}
	
	/**
	 * Adds new product to the database
	 * @param product the product to add
	 * @return the html page to go to (products.html)
	 */
	@PostMapping("/addNew")
	public String addNew(Product product) {
		productService.addNew(product); //adds product to product table
		return "redirect:/product/getAll"; //redirects back to all the results
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Product product) {
		productService.update(product);
		return "redirect:/product/getAll"; //redirects back to all the results
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Product> getOne(Integer bookid) {
		return productService.getOne(bookid);
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer bookid) {
		productService.delete(bookid);
		
		return "redirect:/product/getAll";
	}
}
