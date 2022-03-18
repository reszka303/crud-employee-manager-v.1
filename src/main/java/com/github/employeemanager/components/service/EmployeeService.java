package com.github.employeemanager.components.service;

import com.github.employeemanager.components.exception.UserNotFoundException;
import com.github.employeemanager.components.model.Employee;
import com.github.employeemanager.components.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User by " + id + "was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
