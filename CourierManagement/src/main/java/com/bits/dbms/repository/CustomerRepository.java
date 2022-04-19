package com.bits.dbms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.dbms.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
}
