package com.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ComplianceDao;
import com.dao.DepartmentDao;
import com.to.Compliance;
import com.to.Department;
import com.to.Employee;

@Controller

public class ComplianceOps {
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private ComplianceDao compDao;

	@RequestMapping(value = "/admin/addCompliance",method = RequestMethod.POST)
	public ModelAndView addCompliance(@RequestParam("rltype") String rlType,
							          @RequestParam("rldetails") String rlDetails,
							          @RequestParam("department") int deptId) {
		
		ModelAndView res = new ModelAndView("addCompliance");
		
		Department dept = deptDao.getDeptbyId(deptId);
		
		if(dept == null) {
			res.addObject("color","red");
			res.addObject("message","Unable to add Compliance, Invalid Department ID");
			return res;
			
		}
		
		int compId = compDao.addCompliance(rlType, rlDetails, LocalDate.now() ,dept);
		
		
		res.addObject("color","green");
		res.addObject("message","Added Compliance with ID " + compId);
		
		return res;
	
	}

	@RequestMapping(value = "/user/viewCompliance")
	public ModelAndView viewEmployeeCompliances(HttpSession session){
		
		Employee emp = (Employee) session.getAttribute("employee");
		Department empdept = emp.getDepartment();
		
		
		return new ModelAndView("viewDeptCompliance","complianceList",deptDao.getDeptComplianceList(empdept.getDepartmentId()));

	}

	@RequestMapping("/admin/viewAllCompliances")
	public ModelAndView viewAllCompliances() {
		
		List<Compliance> compList = compDao.getAllCompliance();
		
		ModelAndView res = new ModelAndView("viewCompliance","complianceList",compList);
		res.addObject("statusList", compDao.getStatus(compList));
		
		return res;
	}
	
}
