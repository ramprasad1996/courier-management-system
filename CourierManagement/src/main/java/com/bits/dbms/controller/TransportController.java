package com.bits.dbms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.dbms.model.Orders;
import com.bits.dbms.model.Transport;
import com.bits.dbms.repository.TransportRepository;

@RestController
@CrossOrigin
@RequestMapping(path="/transport")
public class TransportController {
	
	@Autowired
	private TransportRepository transportRepo;
	
	@PostMapping("/addTransport")
	public @ResponseBody String addTransport(@RequestBody Transport transport) {
		transportRepo.save(transport);
		return "Transport saved";
	}
	
	@GetMapping("/getTransport/{transportId}")
	public ResponseEntity<Transport>  addTransport(@PathVariable String transportId ){
		int id = Integer.parseInt(transportId);
		Optional<Transport> transport = transportRepo.findById(id);
		return transport.isPresent() ?  new ResponseEntity<>(transport.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getOrdersByTransportId/{transportId}")
	public ResponseEntity<List<Orders>> getOrdersByTransport(@PathVariable String transportId ) {
		int id = Integer.parseInt(transportId);
		Optional<Transport> transport = transportRepo.findById(id);
		if(transport.isPresent()) {
			return new ResponseEntity<>( transport.get().getOrders(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
