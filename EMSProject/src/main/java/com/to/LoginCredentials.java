package com.to;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class LoginCredentials implements Serializable {
	
	@Id
	private int empid;
	
	@MapsId
	@OneToOne
	private Employee employee;
	private String password;
	private String role;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginCredentials [employee=" + employee + ", password=" + password + ", role=" + role + "]";
	}

	
	
}
