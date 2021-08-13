package com.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.to.Compliance;
import com.to.Department;

@Repository
public class DepartmentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Department> getAllDepts(){
		return hibernateTemplate.loadAll(Department.class);
	}
	
	
	public int addDept(String deptName) {
		
		Department dept = new Department();
		dept.setDepartmentName(deptName);
		return (int) hibernateTemplate.save(dept);
	}
	
	public Department getDeptbyId(int deptId) {
		return hibernateTemplate.get(Department.class,deptId);
		
	}

	public List<Compliance> getDeptComplianceList(int deptId) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Department dept = session.get(Department.class, deptId);
		Hibernate.initialize(dept.getComplianceList());
		List<Compliance> complianceList = dept.getComplianceList();

		
		tx.commit();
		session.close();
		
		return complianceList;
		
	}

}
