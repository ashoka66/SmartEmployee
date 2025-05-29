package com.ak.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ak.model.Employee;
import com.ak.service.IEmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	 private final IEmployeeService service;

	    @GetMapping("/add")
	    public String addPage(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "add";
	    }

	    @PostMapping("/add")
	    public String addEmployee(@ModelAttribute Employee employee,
	                              @RequestParam("file") MultipartFile file,
	                              Model model) {
	        try {
	            service.addEmployee(employee, file);
	            return "redirect:/employee/all";
	        } catch (IOException | RuntimeException e) {
	            model.addAttribute("error", e.getMessage());
	            return "add";
	        }
	    }

	    @GetMapping("/all")
	    public String listEmployees(Model model) {
	        List<Employee> employees = service.searchAll();
	        model.addAttribute("employees", employees);
	        return "lists";
	    }

}
