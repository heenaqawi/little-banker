package com.example.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transfer implements Serializable{

	public Transfer(){
		   // Add here init stuff if needed
		}
	
	  public Transfer(Date date, BigDecimal amount, String debtor_iban, String
	  creditor_iban, String message) {
		  super(); 
		  this.date = date;
		  this.amount =amount;
		  this.debtorIban = debtor_iban;
		  this.creditor_iban = creditor_iban;
		  this.message = message; }
	 
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDebtor_iban() {
		return debtorIban;
	}
	public void setDebtor_iban(String debtor_iban) {
		this.debtorIban = debtor_iban;
	}
	public String getCreditor_iban() {
		return creditor_iban;
	}
	public void setCreditor_iban(String creditor_iban) {
		this.creditor_iban = creditor_iban;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date date;
	private BigDecimal amount;
	@Id
	private String debtorIban;
	private String creditor_iban;
	private String message;
}
