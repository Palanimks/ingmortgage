package com.ing.mortgageloan.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.CustomerRequestDto;
import com.ing.mortgageloan.dto.CustomerResponseDto;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.exception.CommonException;
import com.ing.mortgageloan.repository.CustomerRepository;

/**
 * @author Devdutta Chakrabarti
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@SuppressWarnings("unused")
	@Override
	public CustomerResponseDto register(CustomerRequestDto customerRequestDto) {

		LOGGER.info("Inside CustomerServiceImpl");
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Customer customer = new Customer();

		CustomerResponseDto customerResponseDto = new CustomerResponseDto();

		BeanUtils.copyProperties(customerRequestDto, customer);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		Integer age = Period.between(customerRequestDto.getDateOfBirth(), LocalDate.now()).getYears();
		if (age < 18) {
			throw new CommonException("OHH..Invalid Age");
		}

		if (!customerRequestDto.getEmailId().matches(regex)) {
			throw new CommonException("Invalid Email");
		}
		if (Long.toString(customerRequestDto.getPhoneNumber()).length() < 10) {
			throw new CommonException("Invalid Phone Number");
		}

		customerRepository.save(customer);

		customerResponseDto.setCustomerId(customer.getCustomerId());
		customerResponseDto.setEmailId(customer.getEmailId());
		customerResponseDto.setMessage("Registration Successful");
		customerResponseDto.setStatusCode(201);

		return customerResponseDto;
	}

}
