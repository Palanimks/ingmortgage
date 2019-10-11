package com.ing.mortgageloan.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.mortgageloan.dto.LoginRequestDto;
import com.ing.mortgageloan.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class LoginControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	LoginService loginService;

	LoginRequestDto loginRequestDto;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmailId("dev@gmail.com");
		loginRequestDto.setPassword("abc11");
	}

	@Test
	public void testVerify() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/loan/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(loginRequestDto)))
				.andExpect(status().isFound());
	}

	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
