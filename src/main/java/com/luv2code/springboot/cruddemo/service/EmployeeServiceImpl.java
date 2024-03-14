package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(Long theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public Employee updateEmployeeRecord(Long id, Employee theEmployee) {
        Employee byId = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        byId.setFirstName(theEmployee.getFirstName());
        byId.setLastName(theEmployee.getLastName());


        return employeeRepository.save(byId);
    }

    @Override
    public Employee findByEmailAndUpdateLastName(String email, Employee theEmployee) {
        Employee byEmail = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee with email " + email + " not found."));

        byEmail.setLastName(theEmployee.getLastName());

        return employeeRepository.save(byEmail);
    }
}













