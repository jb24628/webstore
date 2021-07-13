package com.example.webstore.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstore.models.CustomerOrder;
import com.example.webstore.repositories.OrderRepository;
/**
 * Lets the application retrieve and add to MySQL Database
 * @author JB
 *
 */
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<CustomerOrder> getAll() {
		return (List<CustomerOrder>) orderRepository.findAll();
	}
	
	public void addNew(CustomerOrder order) {
		orderRepository.save(order);
	}
	
	public void update(CustomerOrder order) {
		orderRepository.save(order);
	}
	
	public Optional<CustomerOrder> getOne(Integer bookid) {
		return orderRepository.findById(bookid);
	}
	
	public void delete(Integer bookid) {
		orderRepository.deleteById(bookid);
	}
}
