package com.ing.mortgageloan.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ing.mortgageloan.dto.LoginRequestDto;
import com.ing.mortgageloan.dto.LoginResponseDto;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.exception.CommonException;
import com.ing.mortgageloan.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	Customer customer;

	LoginResponseDto loginResponseDto;

	LoginRequestDto loginRequestDto;

	@Before
	public void setup() {

		customer = new Customer();
		customer.setCustomerId(1L);
		customer.setPassword("abc11");
		customer.setFirstName("Dev");
		customer.setEmailId("dev@gmail.com");

		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmailId("dev@gmail.com");
		loginRequestDto.setPassword("abc11");
	}

	@Test
	public void testLogin() {
		logger.info("inside login test");
		Mockito.when(customerRepository.findByEmailIdAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(customer);
		LoginResponseDto loginResponseDto = loginServiceImpl.login(loginRequestDto);
		loginResponseDto.setMessage("Login Successfull");
		Assert.assertEquals("Login Successfull", loginResponseDto.getMessage());
		Assert.assertEquals(Long.valueOf(1L), loginResponseDto.getCustomerId());
	}

	@Test(expected = CommonException.class)
	public void negativeTestLogin() {
		logger.info("inside login test");
		Mockito.when(customerRepository.findByEmailIdAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(null);
		LoginResponseDto loginResponseDto = loginServiceImpl.login(loginRequestDto);
		loginResponseDto.setMessage("Login Successfull");
		Assert.assertEquals("Login Successfull", loginResponseDto.getMessage());
		Assert.assertEquals(Long.valueOf(1L), loginResponseDto.getCustomerId());
	}

}
