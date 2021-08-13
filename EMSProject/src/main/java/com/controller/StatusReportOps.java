package com.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ComplianceDao;
import com.dao.StatusReportDao;
import com.to.Employee;

@RequestMapping("/user")
@Controller
public class StatusReportOps {

	@Autowired
	private ComplianceDao compDao;
	
	@Autowired
	private StatusReportDao reportDao;
	
	@RequestMapping(value = "/updateStatusReports", method = RequestMethod.POST )
	public ModelAndView updatStatusReports(HttpSession session,@RequestParam("compliance") int complianceId, @RequestParam("comments") String comments) {
		
		Employee emp = (Employee) session.getAttribute("employee");
		
		ModelAndView res = new ModelAndView("updateStatusReports");
		
		if(compDao.checkIfExists(complianceId, emp.getDepartment().getDepartmentId()) == false) {
			res.addObject("color", "red");
			res.addObject("message", "Invalid ComplianceId");
			return res;
		}
		
		int reportId = reportDao.addStatusReport(comments, LocalDate.now(), emp.getEmpId(), emp.getDepartment().getDepartmentId(), complianceId);
		res.addObject("color","green");
		res.addObject("message", "Report successfully added/updated with id " + reportId);
		
	
		return res;
	}
	
	@RequestMapping("/viewStatusReports")
	public ModelAndView viewStatusReports(HttpSession session) {
		
		Employee emp = (Employee) session.getAttribute("employee");
		
		
		return  new ModelAndView("/viewStatusReports","reportList",reportDao.reportList(emp.getEmpId()));
		
		
	}
	
}
