package com.ing.mortgageloan.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
	public CustomerResponseDto register(CustomerRequestDto customerRequestDto) throws Exception {
		
		Customer customer=new Customer();
		
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		
		BeanUtils.copyProperties(customerRequestDto, customer);
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//LocalDate date=LocalDate.parse(customerRequestDto.getDateOfBirth(), formatter);
		Integer age=Period.between(customerRequestDto.getDateOfBirth(), LocalDate.now()).getYears();
		if(age<18) {
			throw new Exception("Ohh..You are Child..Money ask to your Parents..Please come after 18 years");
		}
				
		
		
		customerRepository.save(customer);
		
				
		customerResponseDto.setCustomerId(customer.getCustomerId());
		customerResponseDto.setEmailId(customer.getEmailId());
		customerResponseDto.setMessage("Registration Successful");
		customerResponseDto.setStatusCode(201);
	
	
		
		
		
				
		return customerResponseDto;
	}
	
}
