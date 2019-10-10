package com.hcl.ingmortgage.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ingmortgage.dto.UserRequestdto;
import com.hcl.ingmortgage.dto.UserResponsedto;
import com.hcl.ingmortgage.entity.User;
import com.hcl.ingmortgage.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	

	 
	
	@Override
	public UserResponsedto register(UserRequestdto userRequestdto) {
		
		User user=new User();
		
		UserResponsedto userResponsedto=new UserResponsedto();
		
		BeanUtils.copyProperties(userRequestdto, user);
		
		userRepository.save(user);
		
				
		
		userResponsedto.setStatusMessage("Registration Successful");
		userResponsedto.setStatusCode(201);
		
				
		return userResponsedto;
	}
	
}
