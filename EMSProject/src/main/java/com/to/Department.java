package com.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;
	
	@OneToMany
	private List<Employee> employeeList = new ArrayList<>();
	
	@OneToMany
	private List<StatusReport> statusReportList = new ArrayList<>();
	
	@OneToMany
	private List<Compliance> complianceList = new ArrayList<Compliance>();

	public Department() {
		super();		
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<StatusReport> getStatusReportList() {
		return statusReportList;
	}

	public void setStatusReportList(List<StatusReport> statusReportList) {
		this.statusReportList = statusReportList;
	}

	public List<Compliance> getComplianceList() {
		return complianceList;
	}

	public void setComplianceList(List<Compliance> complianceList) {
		this.complianceList = complianceList;
	}
	
	
	
}
