package com.example.webstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.webstore.models.Department;
/**
 * Lets the application communicate with MySQL
 * @author JB
 *
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
