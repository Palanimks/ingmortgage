package com.ing.mortgageloan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgageloan.dto.*;
import com.ing.mortgageloan.service.MortgageLoanService;

@RestController
@RequestMapping("/api")
public class MortgageLoanController {
	
	public static double eligiblePercentage = 80.00;
	public static double ctc = 3.5;
	
	@Autowired
	MortgageLoanService mortgageLoanService;
	
	@PostMapping("/loanmortgage")
	private MortgageResponseDto applyLoan(@Valid @RequestBody MortgageRequestDto mortgageRequestDto) {
		
		return mortgageLoanService.applyLoan(mortgageRequestDto);
		
	}

}
