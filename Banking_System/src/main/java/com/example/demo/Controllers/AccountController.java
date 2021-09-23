package com.example.demo.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Transfer;
import com.example.demo.services.AccountServices;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountServices accountServices;
	
	public AccountController(AccountServices accountServices) {
		super();
		this.accountServices = accountServices;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccountSummary()  // getAccountSummary() is used to get the details of the account present in Account class
	{
		List<Account> getAccountSummary=accountServices.getAccountSummary();
		return new ResponseEntity<>(getAccountSummary,HttpStatus.OK);
	}
	
	

	@PostMapping
	public ResponseEntity<Account> addAccount(@RequestBody Account account)  //addAccount() is used to create the account details of the Customer
	{
		Account addedAccount=accountServices.addAccount(account);
		return new ResponseEntity<>(addedAccount,HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) //updateAccount() is used to update the account details of the Customer if needed.
	{
		Account updatedAccount=accountServices.addAccount(account);
		return new ResponseEntity<>(updatedAccount,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAccount(@PathVariable("id") String Id)  //deleteAccount is used to delete the account details of the Customer
	{
		accountServices.deleteAccount(Id);
	}
	
	
	
	
}
