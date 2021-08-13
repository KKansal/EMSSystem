package com.to;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table
public class Compliance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int complianceId;
	private String rlType;
	private String details;
	private LocalDate createDate;
		
	@OneToMany
	private List<StatusReport> statusReportList;
	
//	@Cascade(CascadeType.)
	@ManyToOne
	private Department department;


	public String getRlType() {
		return rlType;
	}


	public void setRlType(String rlType) {
		this.rlType = rlType;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public LocalDate getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public int getComplianceId() {
		return complianceId;
	}


	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}


	public List<StatusReport> getStatusReportList() {
		return statusReportList;
	}


	public void setStatusReportList(List<StatusReport> statusReportList) {
		this.statusReportList = statusReportList;
	}
	

}
