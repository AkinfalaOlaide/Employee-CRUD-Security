package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long theId);


    Employee save(Employee theEmployee);

   void deleteById(Long theId);

    Employee updateEmployeeRecord(Long id, Employee theEmployee);

    Employee findByEmailAndUpdateLastName(String email, Employee theEmployee);
}


