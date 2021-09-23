package com.example.demo.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountStatement;
import com.example.demo.entities.Transfer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransferRepository;


@Service("transferServices")
public class TransferServices {

    private final AccountRepository accountRepository;
	
    @Autowired
	public TransferServices(AccountRepository accountRepository, TransferRepository transferRepository) {
		super();
		this.accountRepository = accountRepository;
		this.transferRepository = transferRepository;
	}


	private final TransferRepository transferRepository;
	
	public Account findByIban(String iban){
        Account account = accountRepository.findByIbanEquals(iban);
        return account;
    }
	
@Transactional	
public Transfer sendMoney(Transfer transfer) { //This method is used to transfer the amount from one account to another
		
		String fromAccountNumber=transfer.getDebtor_iban();
		String toAccountNumber=transfer.getCreditor_iban();
		BigDecimal amount=transfer.getAmount();
		String msg=transfer.getMessage();
		Date date1=transfer.getDate();
		System.out.println("From account number"+fromAccountNumber+"To AccountNumber"+toAccountNumber+ "for the amount "+amount);
	Account fromAccount=accountRepository.findByIbanEquals(fromAccountNumber);
	//Account fromAccount=accountRepository.findAllById(fromAccountNumber)
	System.out.println("From account is "+fromAccount.toString());
		Account toAccount=accountRepository.findByIbanEquals(toAccountNumber);
		
		if(fromAccount.getBalance().compareTo(BigDecimal.ONE) == 1 &&
		  fromAccount.getBalance().compareTo(amount)==1)
		{
			
			fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
			accountRepository.save(fromAccount);
			toAccount.setBalance(toAccount.getBalance().add(amount));
			accountRepository.save(toAccount);
			Transfer transferredAmount=transferRepository.save(new Transfer(date1,amount,fromAccountNumber,toAccountNumber,msg));
			return transferredAmount;
		}
		
		return transfer;
	}

		public AccountStatement getStatement(String accountNumber) //This method is used to get the transaction statement of a particular account number
		{
	Account account=accountRepository.findByIbanEquals(accountNumber);
	return new AccountStatement(account.getBalance(),transferRepository.findBydebtorIbanEquals(accountNumber));
	
		}



}
