package com.bits.dbms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.dbms.model.Orders;
import com.bits.dbms.model.Transport;
import com.bits.dbms.repository.OrdersRepository;

@RestController
@RequestMapping(path="/orders")
public class OrdersController {

	
	@Autowired
	private OrdersRepository orderRepo;
	
	@PostMapping("/addOrder")
	public @ResponseBody String addOrder(@RequestBody Orders order) {
		orderRepo.save(order);
		return "Order saved";
	}
	
	@GetMapping("/getOrders")
	public List<Orders>  addTransport(){
		return orderRepo.findAll();
	}
	
	@GetMapping("/getOrdersById/{id}")
	public ResponseEntity<Orders> addTransport(@PathVariable String id){
		Optional<Orders> opt =  orderRepo.findById(Integer.parseInt(id));
		return opt.isPresent() ?  new ResponseEntity<>(opt.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
