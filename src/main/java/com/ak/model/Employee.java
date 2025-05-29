package com.ak.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
    private String employeeId; 

    private String firstName;
    private String lastName;
    private String middleName;

    @Column
    private String loginId;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private LocalDate dob;

    private String department;
    private double salary;
    private String permanentAddress;
    private String currentAddress;

    private String idProofPath;

}
