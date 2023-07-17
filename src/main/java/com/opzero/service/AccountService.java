package com.opzero.service;

import java.util.List;
import java.util.Optional;

import com.opzero.entity.Account;

public interface AccountService {
	Account saveAccount(Account account);

	Optional<Account> getAccount(Long accountId);
	
	Account updateAccount(Account account);

	List<Account> getAccounts();
}
