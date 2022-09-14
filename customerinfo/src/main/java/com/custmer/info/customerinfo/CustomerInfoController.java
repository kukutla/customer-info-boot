package com.custmer.info.customerinfo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping(path="/customerinfo")
public class CustomerInfoController {

	@Autowired
	CustomerInfoRepository custRepository;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Customer> getAllCustomers(){
		return custRepository.findAll();
	}
	@PostMapping(path = "save")
	public @ResponseBody String saveCustomer(@RequestBody Customer customer) {
		custRepository.save(customer);
		return "success";
	}
	
	@PutMapping(path = "/update")
	public @ResponseBody String updateCustomer(@RequestBody Customer customer) {
		custRepository.save(customer);
		return "updated";
	}
	
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String deleteCustomer(@PathVariable int id) {
		Optional<Customer> customer = custRepository.findById(id);
		
		if(customer.isPresent()) 
			custRepository.delete(customer.get());
		
			
		return "deleted";
	}
}
