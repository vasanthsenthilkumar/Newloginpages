package com.venkat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.BaseDTO;
import com.venkat.LoginDTO;
import com.venkat.service.LoginService;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/log")
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/user")
	public BaseDTO newLogin(@RequestBody LoginDTO login) {
		BaseDTO response = new BaseDTO();
		response = loginService.newLogin(login);
		return response;
	}
	
	@PostMapping("/login")
	public BaseDTO userlogin(@RequestBody LoginDTO login) {
		BaseDTO response = new BaseDTO();
		response = loginService.userlogin(login);
		return response;
	}
}
