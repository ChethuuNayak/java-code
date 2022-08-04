package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeSeviceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	EmployeeSeviceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Employee saveDetails(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(long id) {
	  Optional<Employee> employee=	employeeRepository.findById(id);
	  if(employee.isPresent())
		  return employee.get();
	  else throw new ResourceNotFoundException("Employee","Id",id);
	  
	}

	@Override
	public Employee updateById(Employee employee, long id) {
		Employee existing=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee","id", id));
		existing.setFirstname(employee.getFirstname());
		existing.setLastname(employee.getLastname());
		existing.setEmail(employee.getEmail());
		employeeRepository.save(existing);
		return existing;
	}
}
