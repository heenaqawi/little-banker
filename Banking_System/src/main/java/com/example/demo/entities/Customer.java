package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Data;


@Data
@Entity 
public class Customer implements Serializable {

	@Id
	private int card_Number;
	private String name;
	public int getCard_Number() {
		return card_Number;
	}
	public void setCard_Number(int card_Number) {
		this.card_Number = card_Number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	
	public Date getCard_DOI() {
		return card_DOI;
	}
	public void setCard_DOI(Date card_DOI) {
		this.card_DOI = card_DOI;
	}
	public Date getCard_DOE() {
		return card_DOE;
	}
	public void setCard_DOE(Date card_DOE) {
		this.card_DOE = card_DOE;
	}

	private String surname;
	private String sex;
	private String nationality;
	@JsonFormat(pattern="dd-MM-yyyy") 
	private Date DOB;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date card_DOI;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date card_DOE;
}
