package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dao.LoginCredentialsDao;
import com.to.LoginCredentials;

@EnableWebMvc
@Controller
public class WelcomePage {
	
	@Autowired
	private LoginCredentialsDao credentialsDao;

	@RequestMapping("/")
	public String displayLoginPage() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public ModelAndView displayLogoutPage(HttpSession session) {
		
		ModelAndView res = new ModelAndView("login");
		
		session.invalidate();
		
		res.addObject("color","green");
		res.addObject("message", "Successfully Logged Out !!!");
		
		return res;
	}
	
	@RequestMapping("/home")
	public ModelAndView verifyDetails(@RequestParam("userId") int userId, @RequestParam("password") String pass, HttpSession session) {
		
		ModelAndView res = new ModelAndView();
		
		LoginCredentials cred = credentialsDao.getCredentialsbyId(userId);
				
		if(cred == null || !cred.getPassword().equals(pass)) {
			res.setViewName("login");
			res.addObject("color","red");
			res.addObject("message","Invalid Credentials");
			return res;
		}
		
	
		
		if(cred.getRole().equals("user")) {
			res.setViewName("user");
		}
		
		if(cred.getRole().equals("admin")) {
			res.setViewName("admin");
		}
		
		session.setAttribute("employee", cred.getEmployee());
		return res;
		
	}

}
