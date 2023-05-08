package com.employeeDetail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.employeeDetail.dao.EmployeeRepository;
import com.employeeDetail.model.Employee;


@Service

public class EmployeeService {
	@Autowired
	EmployeeRepository empRepository;
	public List<Employee> getAllEmployees(){
		List<Employee>empList=empRepository.findAll();
		return empList;
	}
	public Employee saveEmployee(Employee e)
	{
		Employee emp=empRepository.save(e);
		return emp;
	}
	/*public Employee updateEmployee(Employee e)
	{
		Employee emp=empRepository.save(e);
		return emp;
	}*/
	public Employee updateEmployee(Employee e,int empid)
	{
		Optional<Employee> optional=empRepository.findById(empid);
		Employee emp=null;
		if(optional.isPresent())
		{
			/*emp=optional.get();
			emp.setEmpid(e.getEmpid());
			emp.setName(e.getName());
			emp.setShift(e.getShift());
			emp.setPosition(e.getPosition());
			emp.setGender(e.getGender());
			emp.setSpd(e.getSpd());*/
			empRepository.saveAndFlush(e);
		}
		return emp;//return employeeRepository.save(e);
	}
	public Employee getEmployee(int empid)
	{
		Employee e=empRepository.findById(empid).get();
		return e;
	}
	public void deleteEmployee(int empid)
	{
		empRepository.deleteById(empid);
	}
	public List<Employee> sortEmployees(String field)
	{
		return empRepository.findAll(Sort.by(field));
	}
	public List<Employee> sortDesEmployees(String field)
	{
		return empRepository.findAll(Sort.by(Direction.DESC,field));
	}
	public List<Employee> getpaginationss(int offset,int pageSize)
	{
		Page<Employee> paging=empRepository.findAll(PageRequest.of(offset,pageSize));
		return paging.getContent();
	}
	public List<Employee> getsortpaginations(int offset,int pageSize,String field)
	{
		Page<Employee> paging=empRepository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return paging.getContent();
	}
	public String login(String user,int pass)
	{
		List<Employee> li=empRepository.findAll();
		String res=null;
		for(Employee l:li)
		{
			if(l.getFirstname().equals(user)&&l.getEmpid()==pass)
			{
				res="Login successful";
			}
		}
		if(res==null)
		{
			res="Login failed";
		}
		return res;
	}
	public Employee register(@RequestBody Employee id)
	{
		return empRepository.save(id);
	}
}
