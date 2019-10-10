package com.ing.mortgageloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgageloan.dto.CustomerRequestDto;
import com.ing.mortgageloan.dto.CustomerResponseDto;
import com.ing.mortgageloan.dto.LoginRequestDto;
import com.ing.mortgageloan.dto.LoginResponseDto;
import com.ing.mortgageloan.service.CustomerService;
import com.ing.mortgageloan.service.LoginService;



@RestController
@RequestMapping("/mortgage")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerResponseDto> register(@RequestBody CustomerRequestDto customerRequestDto){
		return new ResponseEntity<>(customerService.register(customerRequestDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto logindto) throws Exception {
		return new ResponseEntity<>(loginService.login(logindto), HttpStatus.ACCEPTED);
	}
	
}
