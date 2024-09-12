package org.springframework.data.jpa.repository;

public class JpaRepository {
	package com.webapi.repository;

	import com.webapi.entity.Account;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface AccountRepository extends JpaRepository<Account, Long> {
	
	}

}
