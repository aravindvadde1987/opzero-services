package com.opzero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opzero.entity.Account;
import com.opzero.repository.AccountRepository;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/account")
	public Account getAccount() {
		return accountRepository.findByAccountId(1);
	}

	@PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public Account saveAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
}
