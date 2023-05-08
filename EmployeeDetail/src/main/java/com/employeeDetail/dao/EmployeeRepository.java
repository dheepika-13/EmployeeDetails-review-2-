package com.employeeDetail.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeDetail.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	//positional parameter
	//@Query("select e from Employees where e.monthofjoining=?1 and t.firstname=?2)
	//public List<Employees> getEmployeesByPosition(String position,String firstname);
	//List<Employee> findByNameStartingWith(String prefix);
	//List<Employee> findByNameEndingWith(String suffix);
	//List<Employee> findByPosition(String position);
	
}
