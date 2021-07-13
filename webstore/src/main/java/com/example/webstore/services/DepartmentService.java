package com.example.webstore.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstore.models.Department;
import com.example.webstore.repositories.DepartmentRepository;
/**
 * Lets the application retrieve and add to MySQL Database
 * @author JB
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAll() {
		return (List<Department>) departmentRepository.findAll();
	}
	
	public void addNew(Department department) {
		departmentRepository.save(department);
	}
	
	public void update(Department department) {
		departmentRepository.save(department);
	}
	
	public Optional<Department> getOne(Integer bookid) {
		return departmentRepository.findById(bookid);
	}
	
	public void delete(Integer bookid) {
		departmentRepository.deleteById(bookid);
	}
}
