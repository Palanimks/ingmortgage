package com.ing.mortgageloan.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.CustomerRequestDto;
import com.ing.mortgageloan.dto.CustomerResponseDto;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	

	 
	
	@Override
	public CustomerResponseDto register(CustomerRequestDto customerRequestDto) {
		
		Customer customer=new Customer();
		
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		
		BeanUtils.copyProperties(customerRequestDto, customer);
		
		customerRepository.save(customer);
		
				
		customerResponseDto.setCustomerId(customer.getCustomerId());
		customerResponseDto.setEmailId(customer.getEmailId());
		customerResponseDto.setMessage("Registration Successful");
		customerResponseDto.setStatusCode(201);
	
		
		
				
		return customerResponseDto;
	}
	
}
