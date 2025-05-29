package com.ak.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	Optional<Employee> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

}
