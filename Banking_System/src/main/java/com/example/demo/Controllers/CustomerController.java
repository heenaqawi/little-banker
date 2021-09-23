package com.example.demo.Controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerServices customerService;
	
	@Autowired
	public CustomerController(CustomerServices customerService) {
		super();
		this.customerService = customerService;
	}
    
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers()  //This method is used to retrieve all the Customers
	{
		List<Customer> getAllCustomers=customerService.getAllCustomers();
		return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int Id) //This method is used to get a particular Customer.
	{
		Customer getCustomer=customerService.getCustomer(Id);
		return new ResponseEntity<>(getCustomer,HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) //This method is used to create the Customer
	{
		Customer addedCustomer=customerService.addCustomer(customer);
		return new ResponseEntity<>(addedCustomer,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) //This method is used to update the Customer details
	{
		Customer updatedCustomer=customerService.addCustomer(customer);
		return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") int Id) //This method is used to delete the Customer based on a particular id.
	{
		customerService.deleteCustomer(Id);
	}
	
	
}
