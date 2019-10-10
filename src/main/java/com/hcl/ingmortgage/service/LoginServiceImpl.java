package com.hcl.ingmortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ingmortgage.dto.LoginDto;
import com.hcl.ingmortgage.dto.LoginResponseDto;
import com.hcl.ingmortgage.entity.User;
import com.hcl.ingmortgage.repository.UserRepository;




@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public LoginResponseDto login(LoginDto logindto) {

		LoginResponseDto loginResponseDto = new LoginResponseDto();

		User user = userRepository.findByEmailAndPassword(logindto.getEmailId(), logindto.getPassword());

		if (user == null) {
			throw new RuntimeException();
		}

		loginResponseDto.setMessage("Success");
		loginResponseDto.setStatus("Ok");
		loginResponseDto.setUserId(user.getUserId());
		loginResponseDto.setFirstName(user.getFirstName());
		loginResponseDto.setLastName(user.getLastName());
		return loginResponseDto;
	}
}
