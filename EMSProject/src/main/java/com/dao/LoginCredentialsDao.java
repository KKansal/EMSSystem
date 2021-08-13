package com.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.to.Employee;
import com.to.LoginCredentials;

@Repository
public class LoginCredentialsDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public LoginCredentials getCredentialsbyId(int userId) {

		return hibernateTemplate.get(LoginCredentials.class, userId);
	}

	
}
