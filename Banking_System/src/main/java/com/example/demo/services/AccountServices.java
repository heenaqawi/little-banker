package com.example.demo.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Transfer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransferRepository;

@Service("accountServices")
public class AccountServices {
	
	private final AccountRepository accountRepository;
	
	private final TransferRepository transferRepository;

	public AccountServices(AccountRepository accountRepository, TransferRepository transferRepository) {
		super();
		this.accountRepository = accountRepository;
		this.transferRepository = transferRepository;
	}

	public List<Account> getAccountSummary() {
		
		return accountRepository.findAll();
	}

	public Account addAccount(Account account) {
		
		return accountRepository.save(account);
	}


	public void deleteAccount(String id) {
		 accountRepository.deleteById(id);
		
	}

	

	
	
	
}
