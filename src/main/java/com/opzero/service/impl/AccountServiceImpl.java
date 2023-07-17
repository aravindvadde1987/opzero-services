package com.opzero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opzero.entity.Account;
import com.opzero.repository.AccountRepository;
import com.opzero.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Optional<Account> getAccount(Long id) {
		return accountRepository.findById(id);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

}
