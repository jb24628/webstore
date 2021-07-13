package com.example.webstore.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstore.models.ProductName;
import com.example.webstore.repositories.ProductNameRepository;
/**
 * Lets the application retrieve and add to MySQL Database
 * @author JB
 *
 */
@Service
public class ProductNameService {

	@Autowired
	private ProductNameRepository productNameRepository;
	
	public List<ProductName> getAll() {
		return (List<ProductName>) productNameRepository.findAll();
	}
	
	public void addNew(ProductName productName) {
		productNameRepository.save(productName);
	}
	
	public void update(ProductName productName) {
		productNameRepository.save(productName);
	}
	
	public Optional<ProductName> getOne(Integer bookid) {
		return productNameRepository.findById(bookid);
	}
	
	public void delete(Integer bookid) {
		productNameRepository.deleteById(bookid);
	}
}
