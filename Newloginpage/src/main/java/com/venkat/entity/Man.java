package com.venkat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="man")
@Getter
@Setter
public class Man {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int id;
	
	@Column(name ="name")
	public String name;
	
	@Column(name ="email")
	public String email;
	
	@Column(name ="mobile")
	public String mobile;
	
	
}
