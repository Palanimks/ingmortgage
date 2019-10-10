package com.hcl.ingmortgage.service;

import org.springframework.stereotype.Service;

import com.hcl.ingmortgage.dto.UserRequestdto;
import com.hcl.ingmortgage.dto.UserResponsedto;



@Service
public interface UserService {

	public UserResponsedto register(UserRequestdto userRequestdto);

}
