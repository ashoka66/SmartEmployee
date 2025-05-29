package com.ak.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ak.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee, MultipartFile file) throws IOException;
	public List<Employee> searchAll();

}
