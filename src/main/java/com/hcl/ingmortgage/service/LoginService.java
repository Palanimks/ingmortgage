package com.hcl.ingmortgage.service;

import com.hcl.ingmortgage.dto.LoginDto;
import com.hcl.ingmortgage.dto.LoginResponseDto;

public interface LoginService {

	public LoginResponseDto login(LoginDto customerLogindto);

}
