package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.to.Compliance;
import com.to.Department;
import com.to.Employee;
import com.to.StatusReport;

@Controller
public class StatusReportDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int addStatusReport(String comments, LocalDate creationDate, int empId, int deptId, int compId) {
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Employee e = session.get(Employee.class, empId);
		System.out.println("helllloooo  " + empId );
		Department dept = session.get(Department.class, deptId);
		Compliance comp = session.get(Compliance.class, compId);
		
		Query<StatusReport> q = session.createQuery("select report from StatusReport report where report.employee.id = :empId and report.compliance.id = :compId ");
		q.setParameter("empId",empId);
		q.setParameter("compId", compId);
		
		StatusReport report;
		
		try {
			report = q.getSingleResult();
		}catch(NoResultException except) {
			report = new StatusReport();
			e.getStatusReportList().add(report);
			dept.getStatusReportList().add(report);
			comp.getStatusReportList().add(report);
		}
		report.setComments(comments);
		report.setCreateDate(creationDate);
		report.setEmployee(e);
		report.setDepartment(dept);
		report.setCompliance(comp);
		
		
		int reportId = (int)session.save(report);
		session.merge(e);
		session.merge(dept);
		session.merge(comp);
		
		session.getTransaction().commit();
		session.close();
		
		return reportId;
	}
	
	
	public List<StatusReport> reportList(int empId){
		
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		
		Query<StatusReport> query = sess.createQuery("select report from StatusReport report where report.employee.id = :empId");
		query.setParameter("empId", empId);
		
		List<StatusReport> reportList = query.getResultList();
		
		return reportList;
		
		
		
	}
	
}
