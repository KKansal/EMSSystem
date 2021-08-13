package com.to;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
@Embeddable
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private String firstName;
	private String lastName;
	private LocalDate DOB;
	private String emailId;
	
	@ManyToOne
	private Department department;
	
	@OneToMany
	private List<StatusReport> statusReportList;

	
	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, LocalDate dOB, String emailId, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.emailId = emailId;
		this.department = department;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getDOB() {
		return DOB;
	}


	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<StatusReport> getStatusReportList() {
		return statusReportList;
	}


	public void setStatusReportList(List<StatusReport> statusReportList) {
		this.statusReportList = statusReportList;
	}
	
	

}
