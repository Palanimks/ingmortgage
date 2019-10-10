package com.ing.mortgageloan.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.MortgageRequestDto;
import com.ing.mortgageloan.dto.MortgageResponseDto;
import com.ing.mortgageloan.entity.Account;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.entity.MortgageLoan;
import com.ing.mortgageloan.exception.CommonException;
import com.ing.mortgageloan.repository.*;

@Service
public class MortgageLoanServiceImpl implements MortgageLoanService{

	public static final String status = "Applied";
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	MortgageLoanRepository mortgageLoanRepository;
	
	@Override
	public MortgageResponseDto applyLoan(MortgageRequestDto mortgageRequestDto) {
		
		Optional<Customer> customer=customerRepository.findById(mortgageRequestDto.getCustomerId());
		Account account = new Account();
		MortgageLoan mortgageLoan= new MortgageLoan();
		MortgageResponseDto mortgageResponseDto=new MortgageResponseDto();
		
		if(!customer.isPresent()) {
			
			throw new CommonException("Customer Not Found");
		}
		//updating customer
		customer.get().setAnnualSalary(mortgageRequestDto.getAnnualSalary());
		customerRepository.save(customer.get());
		//creating account
		account.setCustomerId(customer.get());
		accountRepository.save(account);
		//creating loan
		BeanUtils.copyProperties(mortgageRequestDto, mortgageLoan);
		mortgageLoan.setCustomerId(customer.get());
		mortgageLoan.setStatus(status);
		MortgageLoan mortgageLoanResponse=mortgageLoanRepository.save(mortgageLoan);
		
		//setting response
		mortgageResponseDto.setLoanAccountNumber(mortgageLoanResponse.getLoanAccountNumber());
		mortgageResponseDto.setStatus(mortgageLoanResponse.getStatus());
		mortgageResponseDto.setStatusCode(200);
		mortgageResponseDto.setMessage("Loan Application Success");
		
		return mortgageResponseDto;
		
	}

}
