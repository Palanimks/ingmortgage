package com.ing.mortgageloan.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.LoginRequestDto;
import com.ing.mortgageloan.dto.LoginResponseDto;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.repository.CustomerRepository;






@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {

		LoginResponseDto loginResponseDto = new LoginResponseDto();

		Customer customer = customerRepository.findByEmailIdAndPassword(loginRequestDto.getEmailId(), loginRequestDto.getPassword());

		if (customer == null) {
			throw new RuntimeException();
		}

		loginResponseDto.setMessage("Success");
		loginResponseDto.setStatusCode(201);
		loginResponseDto.setCustomerId(customer.getCustomerId());
		loginResponseDto.setEmailId(customer.getEmailId());
		return loginResponseDto;
	}
}

