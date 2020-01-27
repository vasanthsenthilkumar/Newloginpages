package com.venkat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.entity.Man;

public interface Manrepository extends JpaRepository<Man, Integer>{
	
  List<Man> findById(int id); 
  
}
