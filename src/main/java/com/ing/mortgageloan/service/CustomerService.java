package com.ing.mortgageloan.service;

import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.CustomerRequestDto;
import com.ing.mortgageloan.dto.CustomerResponseDto;

@Service
public interface CustomerService {

	public CustomerResponseDto register(CustomerRequestDto customerRequestDto) throws Exception;

}
