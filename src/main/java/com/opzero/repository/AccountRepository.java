package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	List<Account> findAll();
}