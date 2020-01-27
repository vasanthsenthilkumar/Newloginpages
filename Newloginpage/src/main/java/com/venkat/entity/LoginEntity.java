package com.venkat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="user")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class LoginEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
    public int userId;
	
	@Column(name = "username")
    private String userName;
	
	@Column(name = "password")
    public String password;
    
    @Column(name = "email")
    private String email;
	  
}
