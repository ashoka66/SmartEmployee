package com.ak.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ak.model.Employee;
import com.ak.repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public Employee addEmployee(Employee employee, MultipartFile file) throws IOException {
       
        if (Period.between(employee.getDob(), LocalDate.now()).getYears() < 18) {
            throw new RuntimeException("Employee must be 18 or older");
        }

        
        String loginId = generateLoginId(employee.getFirstName(), employee.getLastName());
        employee.setLoginId(loginId);

        
        String employeeId = UUID.randomUUID().toString().substring(0, 5).toUpperCase() + repository.count();
        employee.setEmployeeId(employeeId);

        
        if (!file.getOriginalFilename().endsWith(".pdf") || file.getSize() < 10_000 || file.getSize() > 1_000_000) {
            throw new RuntimeException("Invalid file: must be PDF and 10KB–1MB");
        }

       
        File folder = new File(uploadDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = uploadDir + File.separator + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        employee.setIdProofPath(filePath);

        
        return repository.save(employee);
    }

    private String generateLoginId(String firstName, String lastName) {
        String base = (firstName.charAt(0) + lastName).toLowerCase();
        String loginId = base;
        Random random = new Random();

        while (repository.existsByLoginId(loginId)) {
            loginId = base + String.format("%03d", random.nextInt(1000));
        }

        return loginId;
    }

    @Override
    public List<Employee> searchAll() {
        return repository.findAll();
    }
}
