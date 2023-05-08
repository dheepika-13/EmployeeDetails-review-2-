package com.employeeDetail.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee_Details")
public class Employee {
	@Id
	private int empid;
	private String firstname;
	private String lastname;
	private String shift;
	private String position;
	private String gender;
	private int spd;
	private int experience;
	private int yearofjoining;
	private int allowances;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getYearofjoining() {
		return yearofjoining;
	}
	public void setYearofjoining(int yearofjoining) {
		this.yearofjoining = yearofjoining;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getAllowances() {
		return allowances;
	}
	public void setAllowances(int allowances) {
		this.allowances = allowances;
	}

}
