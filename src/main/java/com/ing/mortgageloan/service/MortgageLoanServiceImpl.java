package com.ing.mortgageloan.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ing.mortgageloan.dto.MortgageRequestDto;
import com.ing.mortgageloan.dto.MortgageResponseDto;
import com.ing.mortgageloan.entity.Account;
import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.entity.MortgageLoan;
import com.ing.mortgageloan.exception.CommonException;
import com.ing.mortgageloan.repository.*;

import lombok.extern.slf4j.Slf4j;

/**
 * @author User1
 *
 */
@Service
@Slf4j
public class MortgageLoanServiceImpl implements MortgageLoanService{

	public static final String status = "Applied";
	
	@Value("${exceptions.customer.notfound}")
	private String customerConstant;
	
	@Value("${exceptions.customer.noteligible}")
	private String eligibleConstant;
	
	@Value("${status.code}")
	private Integer successStatusCode;
	
	@Value("${loan.success.message}")
	private String successMessage;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	MortgageLoanRepository mortgageLoanRepository;
	
	
	@Override
	public MortgageResponseDto applyLoan(MortgageRequestDto mortgageRequestDto) {
		
		//log.info("Into Loan Apply Service");
		
		Optional<Customer> customer=customerRepository.findById(mortgageRequestDto.getCustomerId());
		Account account = new Account();
		MortgageLoan mortgageLoan= new MortgageLoan();
		MortgageResponseDto mortgageResponseDto=new MortgageResponseDto();
		
		if(!customer.isPresent()) {
			
			throw new CommonException(customerConstant);
		}
		Double isEligible=(mortgageRequestDto.getAnnualSalary()/12)/2;
		
		//log.info("Is Eligible?"+isEligible+"EMI"+mortgageRequestDto.getEmi());
		if(isEligible.compareTo(mortgageRequestDto.getEmi()) != 1) {
			throw new CommonException(eligibleConstant);
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
		mortgageResponseDto.setStatusCode(successStatusCode);
		mortgageResponseDto.setMessage(successMessage);
		
		return mortgageResponseDto;
		
	}
	
	@Scheduled(cron = "0 */3 * ? * *")
	public void emi() {
		
		//log.info("Into EMI Repayment Service");
		
		List<Customer> customerList=customerRepository.findAll();
		System.out.println("------"+customerList);
		customerList.stream().forEach(customer ->{
			Account account = accountRepository.findByCustomerId(customer);
			MortgageLoan mortgageLoan = mortgageLoanRepository.findByCustomerId(customer);
			
			//log.info("Account"+account+"MortgageLoan"+mortgageLoan);
			
			if( account != null && mortgageLoan != null && mortgageLoan.getOutstandingAmount() > 0 && mortgageLoan.getTenure() > 0) {
				if(account.getAccountBalance() < mortgageLoan.getEmi()) {
					throw new CommonException("Insufficient Account Balance");
				}
				else {
					account.setAccountBalance(account.getAccountBalance()-mortgageLoan.getEmi());
					mortgageLoan.setOutstandingAmount(mortgageLoan.getOutstandingAmount()-mortgageLoan.getEmi());
					mortgageLoan.setTenure(mortgageLoan.getTenure()-1);
				}
				accountRepository.save(account);
				mortgageLoanRepository.save(mortgageLoan);
			}
			
		});
	   }

}
