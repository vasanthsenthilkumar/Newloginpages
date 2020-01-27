package com.venkat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.entity.LoginEntity;
@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,String > {
	
	LoginEntity findByUserName(String username);
}
