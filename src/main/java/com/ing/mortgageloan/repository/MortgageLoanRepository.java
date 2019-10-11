package com.ing.mortgageloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgageloan.entity.Customer;
import com.ing.mortgageloan.entity.MortgageLoan;

@Repository
public interface MortgageLoanRepository extends JpaRepository<MortgageLoan, Long>{
	
	MortgageLoan findByCustomerId(Customer customerId);

}
