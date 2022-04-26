package com.bits.dbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.bits.dbms.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
