package com.venkat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.venkat.BaseDTO;
import com.venkat.LoginDTO;
import com.venkat.entity.LoginEntity;
import com.venkat.repository.LoginRepository;

import lombok.extern.log4j.Log4j2;

@Service
public class LoginService {
	@Autowired
	LoginRepository userrepository;

	@Autowired
	private PasswordEncoder encoder;
	
	public BaseDTO newLogin(LoginDTO login) {
		BaseDTO response = new BaseDTO();
		try {

			LoginEntity entity = new LoginEntity();
			BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
			String value=bCryptPasswordEncoder.encode(login.getPassword());
			entity.setUserName(login.getUserName());
			entity.setPassword(value);
			userrepository.save(entity);
			response.setMessage("Added");

		} catch (Exception e) {
		//	log.info("error", e);
			response.setMessage("failure");
		}
		return response;
	}


	public BaseDTO userlogin(LoginDTO login) {
		BaseDTO response=new BaseDTO();
		String valueuser=login.getUserName();
		String valuepass=login.getPassword();
		try {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			LoginEntity login1=userrepository.findByUserName(valueuser);
			if(login1!=null) {
				Boolean success=encoder.matches(valuepass, login1.getPassword());
				if(success==true) {
					response.setMessage("login Successful");
				}
				else {
					response.setMessage("invalid credentials");
				}
			} else {
				response.setMessage("not found");
			}
			
			
		}catch(Exception e) {
			response.setMessage("failure");
		}
	
		return response;
	}

}
