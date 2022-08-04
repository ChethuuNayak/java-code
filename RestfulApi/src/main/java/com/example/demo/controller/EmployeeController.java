package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	EmployeeController(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	@PostMapping
   public ResponseEntity<Employee> saveDetails(@RequestBody Employee employee) {
	   return new ResponseEntity<Employee>(employeeService.saveDetails(employee), HttpStatus.FOUND);
   }
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	@GetMapping({"id"})
	public ResponseEntity<Employee> getById( @PathVariable("id")  long empId) {
		return new ResponseEntity<Employee>(employeeService.getById(empId), HttpStatus.OK);
		
	}
	@PutMapping({"id"})
	public ResponseEntity<Employee> updateEmp(@PathVariable ("id")long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateById(employee, id),HttpStatus.OK);
		
	}
	
}
