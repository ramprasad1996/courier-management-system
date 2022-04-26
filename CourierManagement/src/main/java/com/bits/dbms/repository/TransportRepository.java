package com.bits.dbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.dbms.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

}
