package com.opzero.repository;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByAccountId(long accountId);
	
	@SuppressWarnings("unchecked")
	Account save(Account account);
}