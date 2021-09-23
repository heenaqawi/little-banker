package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

@Service("customerServices")
public class CustomerServices {

	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServices(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll(); //This method is used to find all the Customers
	}


	public Customer getCustomer(int Id) {
		
		return customerRepository.findById(Id).orElseThrow();
	}


	public Customer addCustomer(Customer customer) {
	
		return customerRepository.save(customer); //This method is used to create a customer in customer repository
		
	}


	public void deleteCustomer(int id) {
		
		customerRepository.deleteById(id); // This method is used to delete the Customer based on a particular id.
		
	}


	

	
	
}
