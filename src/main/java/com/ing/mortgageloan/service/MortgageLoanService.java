package com.ing.mortgageloan.service;

import com.ing.mortgageloan.dto.MortgageRequestDto;
import com.ing.mortgageloan.dto.MortgageResponseDto;

public interface MortgageLoanService {
	
	public MortgageResponseDto applyLoan(MortgageRequestDto mortgageRequestDto);
}
