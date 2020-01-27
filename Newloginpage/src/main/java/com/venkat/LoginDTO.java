package com.venkat;

import java.io.Serializable;

import lombok.Data;
@Data
public class LoginDTO implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 6763676437224318708L;
private String userName;
private String password;
}
