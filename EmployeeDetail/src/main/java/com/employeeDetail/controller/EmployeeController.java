package com.employeeDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeDetail.model.Employee;
import com.employeeDetail.service.EmployeeService;



@RestController
public class EmployeeController {
	
		@Autowired
		EmployeeService empService;
		@GetMapping(value="/fetchEmployees")
		public List<Employee>getAllEmployees(){
			List<Employee>empList=empService.getAllEmployees();
			return empList;
		}
		@PostMapping(value="/saveEmployee")
		public Employee saveEmployee(@RequestBody Employee e)
		{
			return empService.saveEmployee(e);
		}
		@PutMapping(value="/updateEmployee")
		public Employee updateEmployee(@RequestBody Employee e)
		{
			return empService.saveEmployee(e);
		}
		@DeleteMapping(value="/deleteEmployee/{empid}")
		public void deleteEmployee(@PathVariable("empid") int empid)
		{
			empService.deleteEmployee(empid);
		}
		@GetMapping(value="/getemployee/{empid}")
		public Employee getEmployee(@PathVariable("empid") int empid)
		{
			return empService.getEmployee(empid);
		}
		@GetMapping(value="/auto/{field}")
		public List<Employee> sortEmployeeD(@PathVariable String field)
		{
			return empService.sortEmployees(field);
		}
		@GetMapping(value="/autio")
		public List<Employee> sortEmployeeDes(@RequestParam String field)
		{
			return empService.sortDesEmployees(field);
		}
		@GetMapping(value="/pagination")
		public List<Employee> Pagination(@RequestParam int offset,@RequestParam int pageSize)
		{
			return empService.getpaginationss(offset, pageSize);
		}
		@GetMapping("/sortpagination")
		public List<Employee> sortpagination(@RequestParam int offset,@RequestParam int pageSize,String field)
		{
			return empService.getsortpaginations(offset,pageSize,field);
		}
		@GetMapping("/login")
		public String login(@RequestParam String user,@RequestParam int pass)
		{
			return empService.login(user,pass);
		}
		@PostMapping("/reg")
		public Employee empid(@RequestBody Employee id)
		{
			return empService.register(id);
		}


}