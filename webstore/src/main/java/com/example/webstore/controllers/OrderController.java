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

import com.example.webstore.models.CustomerOrder;
import com.example.webstore.services.OrderService;

/**
 * handles mappings for orders
 * @author JB
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	/**
	 * Interacts with the database
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * Shows 
	 * @param model what stores what we put on the website
	 * @return the html page to go to (orders.html)
	 */
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<CustomerOrder> order = orderService.getAll();
		
		model.addAttribute("order", order);
		return "order";
	}
	
	/**
	 * Adds new order to the database
	 * @param order the order to add
	 * @return the html page to go to (orders.html)
	 */
	@PostMapping("/addNew")
	public String addNew(CustomerOrder order) {
		orderService.addNew(order); //adds order to order table
		return "redirect:/order/getAll"; //redirects back to all the results
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(CustomerOrder order) {
		orderService.update(order);
		return "redirect:/order/getAll"; //redirects back to all the results
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<CustomerOrder> getOne(Integer bookid) {
		return orderService.getOne(bookid);
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer bookid) {
		orderService.delete(bookid);
		
		return "redirect:/order/getAll";
	}
}
