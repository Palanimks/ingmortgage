package com.ing.mortgageloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.mortgageloan.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
