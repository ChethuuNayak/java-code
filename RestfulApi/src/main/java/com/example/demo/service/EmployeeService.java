package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
    Employee saveDetails(Employee employee);
    
    List<Employee> getEmployees();
    
    Employee getById(long id);
    
    Employee updateById(Employee employee,long id);

}
