package com.ing.mortgageloan.service;

import com.ing.mortgageloan.dto.LoginRequestDto;
import com.ing.mortgageloan.dto.LoginResponseDto;

public interface LoginService {

	public LoginResponseDto login(LoginRequestDto loginRequestDto);

}
