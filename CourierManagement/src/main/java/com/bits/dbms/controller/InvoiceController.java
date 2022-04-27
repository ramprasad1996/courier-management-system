package com.bits.dbms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.dbms.model.Invoice;
import com.bits.dbms.model.Orders;
import com.bits.dbms.repository.OrdersRepository;

@RestController
@CrossOrigin
@RequestMapping(path="/invoice")
public class InvoiceController {

	@Autowired
	private OrdersRepository ordersRepo;
	
	@GetMapping("/getInvoiceById/{id}")
	public @ResponseBody Invoice addOrder(@PathVariable String id) {
		Optional<Orders> orders =ordersRepo.findById(Integer.parseInt(id));
		
		return orders.isPresent() ? orders.get().getInvoice() : null; 
	}
}
