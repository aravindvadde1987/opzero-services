package com.opzero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Account;
import com.opzero.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/account/{accountId}")
	public ResponseEntity<Object> getAccount(@PathVariable("accountId") Long accountId) {
		if (accountService.getAccount(accountId) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account is not found for given id " + accountId);
		}
		return ResponseEntity.ok(accountService.getAccount(accountId));
	}

	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		if (accountService.getAccounts().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accounts not found");
		}
		return accountService.getAccounts();
	}

	@PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public Account saveAccount(@RequestBody Account account) {
		if (accountService.getAccount(account.getAccountId()) != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"account already exist for given accountId=" + account.getAccountId());
		}
		return accountService.saveAccount(account);
	}

	@PutMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public Account updateAccount(@RequestBody Account account) {
		if (accountService.getAccount(account.getAccountId()) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"account is not found for given id " + account.getAccountId());
		}
		return accountService.updateAccount(account);
	}
}
