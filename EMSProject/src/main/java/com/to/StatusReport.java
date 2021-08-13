package com.to;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class StatusReport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusRpId;
	private String comments;
	private LocalDate createDate;
	
	@ManyToOne
	private Compliance compliance;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Employee employee;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Compliance getCompliance() {
		return compliance;
	}

	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}

	public int getStatusRpId() {
		return statusRpId;
	}

	public void setStatusRpId(int statusRpId) {
		this.statusRpId = statusRpId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	

}
