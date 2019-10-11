package com.ing.mortgageloan.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.mortgageloan.dto.CustomerRequestDto;
import com.ing.mortgageloan.dto.CustomerResponseDto;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.repository.CustomerRepository;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@Autowired
	CustomerServiceImpl customerService;

	

	@MockBean
	CustomerRepository customerRepository;
	
	
	
	CustomerRequestDto customerRequestDto = null;
	CustomerResponseDto customerResponseDto = null;
	Customer customer = null;

	
	@Test
	public void registerCustomerTest() throws Exception {
		customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setFirstName("Dev");
		customerRequestDto.setLastName("abc");
		customerRequestDto.setEmailId("abc@gmail.com");
		customerRequestDto.setPassword("Dev@09");
		customerRequestDto.setPhoneNumber(898L);
		customerRequestDto.setAnnualSalary(88.0);
		customerRequestDto.setDateOfBirth(LocalDate.of(1991, 11, 11));
				
		customer = new Customer();
		customer.setCustomerId(1L);
		
	
		
		customerResponseDto = new CustomerResponseDto();
		customerResponseDto.setMessage("You have Successfully Registered.....");
		
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		
		
		
		assertEquals(customerResponseDto.getMessage(), customerService.register(customerRequestDto).getMessage());
		
	}
}
	

