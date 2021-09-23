package com.example.demo.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountStatement;
import com.example.demo.entities.Transfer;
import com.example.demo.services.AccountServices;
import com.example.demo.services.TransferServices;

@RestController
@EnableTransactionManagement
@RequestMapping("/api/transferAmount")
public class TransferController {

	@Autowired
	private final TransferServices transferServices;
	

	
	
	public TransferController(TransferServices transferServices) {
		super();
		this.transferServices = transferServices;
	}


  
	@PostMapping("/sendMoney")
	public ResponseEntity<Transfer> sendMoney(@RequestBody Transfer transfer) //This method is used to transfer the amount from one account to another
	{
		Transfer transferAmount=transferServices.sendMoney(transfer);
		return new ResponseEntity<Transfer>(transferAmount,HttpStatus.OK);
	}
	
	
	  @PostMapping("/statement") 
	  public ResponseEntity<AccountStatement> getStatement(@RequestBody AccountStatementRequest accountStatementRequest) //This method is used get the transaction history of a particular account number
	  {
	  
	  AccountStatement statement=transferServices.getStatement(accountStatementRequest.
	  getAccountNumber());
	  return new ResponseEntity<AccountStatement>(statement,HttpStatus.OK);
	  
	  }
	 
	
	

	
	
	
	
}
