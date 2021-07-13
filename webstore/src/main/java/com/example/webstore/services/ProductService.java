package com.example.webstore.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstore.models.Product;
import com.example.webstore.repositories.ProductRepository;
/**
 * Lets the application retrieve and add to MySQL Database
 * @author JB
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll() {
		return (List<Product>) productRepository.findAll();
	}
	
	public void addNew(Product product) {
		productRepository.save(product);
	}
	
	public void update(Product product) {
		productRepository.save(product);
	}
	
	public Optional<Product> getOne(Integer bookid) {
		return productRepository.findById(bookid);
	}
	
	public void delete(Integer bookid) {
		productRepository.deleteById(bookid);
	}
}
