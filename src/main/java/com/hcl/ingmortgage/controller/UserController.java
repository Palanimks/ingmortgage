package com.hcl.ingmortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ingmortgage.dto.LoginDto;
import com.hcl.ingmortgage.dto.LoginResponseDto;
import com.hcl.ingmortgage.dto.UserRequestdto;
import com.hcl.ingmortgage.dto.UserResponsedto;
import com.hcl.ingmortgage.service.LoginService;
import com.hcl.ingmortgage.service.UserService;


@RestController
@RequestMapping("/mortgage")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponsedto> register(@RequestBody UserRequestdto userRequestdto){
		return new ResponseEntity<>(userService.register(userRequestdto),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto customerLogindto) throws Exception {
		return new ResponseEntity<>(loginService.login(customerLogindto), HttpStatus.ACCEPTED);
	}
	
}
