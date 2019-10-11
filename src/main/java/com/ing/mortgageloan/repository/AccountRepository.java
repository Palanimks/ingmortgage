package com.ing.mortgageloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.mortgageloan.entity.Account;
import com.ing.mortgageloan.entity.Customer;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByCustomerId(Customer customerId);

}
