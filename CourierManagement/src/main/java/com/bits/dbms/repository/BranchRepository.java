package com.bits.dbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.dbms.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

}
