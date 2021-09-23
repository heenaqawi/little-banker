package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatement {
	BigDecimal currentBalance;
    List<Transfer> transactionHistory;
    
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Transfer> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<Transfer> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public AccountStatement(BigDecimal currentBalance, List<Transfer> transactionHistory) {
		super();
		this.currentBalance = currentBalance;
		this.transactionHistory = transactionHistory;
	}
}
