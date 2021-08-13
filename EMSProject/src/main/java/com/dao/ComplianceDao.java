package com.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.hibernate.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.to.Compliance;
import com.to.Department;

@Repository
public class ComplianceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public int addCompliance(String rltype,String rldetails,LocalDate currDate ,Department dept) {
		
		Compliance comp = new Compliance();
		
		comp.setRlType(rltype);
		comp.setCreateDate(currDate);
		comp.setDetails(rldetails);
		comp.setDepartment(dept);
		
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		
		Department newDept = sess.get(Department.class, dept.getDepartmentId());
		Hibernate.initialize(newDept.getComplianceList());
		newDept.getComplianceList().add(comp);

		int compId = (int) sess.save(comp);
		sess.merge(newDept);
		
		tx.commit();
		sess.close();
		
		return compId;
	}
	
	public boolean checkIfExists(int compId, int deptId) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		javax.persistence.Query q = session.createQuery("From Compliance where Compliance.complianceId = :compId and Compliance.department.id = :deptId");
		Query q = session.createSQLQuery("Select * from compliance where complianceId = :compId and department_departmentId = :deptId");
		q.setParameter("compId",compId);
		q.setParameter("deptId", deptId);
		
		List<Compliance> compList = q.getResultList();
		
		
		session.getTransaction().commit();
		
		session.close();
		
		return compList.size() == 1 ;
		
	}

	public List<Compliance> getAllCompliance() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Compliance");
		
		List<Compliance> complianceList = q.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return complianceList;
	}

	public List<String> getStatus(List<Compliance> compList) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<String> statusList = compList.stream().map(comp -> {
			comp = session.get(Compliance.class, comp.getComplianceId());
			int actual = comp.getStatusReportList().size();
			int expect = comp.getDepartment().getEmployeeList().size();
			System.out.println(actual + " " + expect);
			return actual == expect ? "Pass" : "Fail" ;
		}).collect(Collectors.toList());
		
		session.getTransaction().commit();
		session.close();
		
		return statusList;
		
		
		
	}
	
}
