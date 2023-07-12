package com.opzero.service;

import com.opzero.entity.Account;

public interface AccountService {
	Account saveAccount(Account account);

	Account getAccount(Long accountId);
	
	Account updateAccount(Account account);
}
