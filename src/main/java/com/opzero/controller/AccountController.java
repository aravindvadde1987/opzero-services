package com.opzero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opzero.entity.Account;
import com.opzero.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/account/{accountId}")
	public Account getAccount(@PathVariable("accountId") Long accountId) {
		return accountService.getAccount(accountId);
	}

	@PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public Account saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@PutMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public Account updateAccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}
}
