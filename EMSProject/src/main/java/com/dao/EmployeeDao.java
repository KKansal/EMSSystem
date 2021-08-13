package com.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.to.Department;
import com.to.Employee;

@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Employee getEmployeebyId(int empId) {	
		return hibernateTemplate.get(Employee.class,empId);
	}
	
	public int addEmployee(String fname,
							String lname,
							LocalDate DOB,
							String email,
							Department dept) {
		
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee emp = new Employee(fname,lname,DOB,email,dept);
		
		Department deptObj = session.get(Department.class, dept.getDepartmentId());
		deptObj.getEmployeeList().add(emp);
		
		session.saveOrUpdate(deptObj);
		int empId = (int) session.save(emp);
		
		
		session.getTransaction().commit();
		session.close();
		return empId;
	
	}
	
	public boolean editEmployee(int empId,
			String fname,
			String lname,
			LocalDate DOB,
			String email,
			Department dept) {
		

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee emp = session.get(Employee.class, empId);
		if(emp == null)
			return false;
		
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setDepartment(dept);
		emp.setDOB(DOB);
		emp.setEmailId(email);
		
		session.update(emp);
		session.getTransaction().commit();
		session.close();
		
		return true;
				

}
	@Transactional
	public boolean deleteEmployee(int empId) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = getEmployeebyId(empId);
		
		if(emp == null)
			return false;
		
		session.delete(emp);
		
		tx.commit();
		session.close();
		return true;
	}
	
	
	
	
	
	public List<Employee> getAllEmployees(){
		return hibernateTemplate.loadAll(Employee.class);
	}
	
}
