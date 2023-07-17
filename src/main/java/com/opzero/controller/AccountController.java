package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Account;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/account/{id}")
	public MasterDTO getAccount(@PathVariable("id") Long id) {
		if (!accountService.getAccount(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account is not found for given id " + id);
		}
		return modelMapper.map(accountService.getAccount(id).get(), MasterDTO.class);
	}

	@GetMapping("/accounts")
	public List<MasterDTO> getAccounts() {
		if (accountService.getAccounts().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accounts not found");
		}
		return accountService.getAccounts().stream().map(account -> modelMapper.map(account, MasterDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public MasterDTO saveAccount(@RequestBody MasterDTO masterDTO) {
		Account account = accountService.saveAccount(modelMapper.map(masterDTO, Account.class));
		return modelMapper.map(account, MasterDTO.class);
	}

	@PutMapping(value = "/account", consumes = "application/json", produces = "application/json")
	public MasterDTO updateAccount(@RequestBody MasterDTO masterDTO) {
		if (!accountService.getAccount(masterDTO.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"account is not found for given id " + masterDTO.getId());
		}
		Account account = accountService.saveAccount(modelMapper.map(masterDTO, Account.class));
		return modelMapper.map(account, MasterDTO.class);
	}
}
