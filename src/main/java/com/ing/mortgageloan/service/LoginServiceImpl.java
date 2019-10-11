package com.ing.mortgageloan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.LoginRequestDto;
import com.ing.mortgageloan.dto.LoginResponseDto;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.exception.CommonException;
import com.ing.mortgageloan.repository.CustomerRepository;

/**
 * @author Devdutta Chakrabarti
 *
 */

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {

		LOGGER.info("Inside LoginServiceImpl");
		LoginResponseDto loginResponseDto = new LoginResponseDto();

		Customer customer = customerRepository.findByEmailIdAndPassword(loginRequestDto.getEmailId(),
				loginRequestDto.getPassword());

		if (customer == null) {
			throw new CommonException("wrong password");
		}

		loginResponseDto.setMessage("Success");
		loginResponseDto.setStatusCode(201);
		loginResponseDto.setCustomerId(customer.getCustomerId());
		loginResponseDto.setEmailId(customer.getEmailId());
		return loginResponseDto;
	}
}
