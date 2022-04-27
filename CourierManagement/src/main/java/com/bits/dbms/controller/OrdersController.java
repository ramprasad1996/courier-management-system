package com.bits.dbms.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.dbms.model.Invoice;
import com.bits.dbms.model.Orders;
import com.bits.dbms.repository.InvoiceRepository;
import com.bits.dbms.repository.OrdersRepository;
import com.bits.dbms.utils.UpdateUtil;

@RestController
@CrossOrigin
@RequestMapping(path="/orders")
public class OrdersController {

	
	@Autowired
	private OrdersRepository orderRepo;
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@PostMapping("/addOrder")
	public @ResponseBody String addOrder(@RequestBody Orders order) {
		 Calendar cal = Calendar.getInstance();
		 order.setOrderTimestamp(new Timestamp(cal.getTimeInMillis()));
		Orders savedOrder = orderRepo.save(order);
		generateInvoice(savedOrder);
		
		return "Order saved";
	}
	
	private void generateInvoice(Orders savedOrder) {
		Invoice invoice= new Invoice();
		int quantity = savedOrder.getWeight();
		int invoiceAmount = 10*quantity;
		invoice.setBranchId(savedOrder.getSrcBranchId().getBranchId());
		invoice.setEmpId(savedOrder.getEmpId());
		invoice.setGst(18);
		invoice.setInvoiceAmount(invoiceAmount);
		invoice.setOrders(savedOrder);
		invoice.setInvoiceDate(savedOrder.getOrderTimestamp());
		invoiceRepo.save(invoice);
		
	}

	@GetMapping("/getOrders")
	public List<Orders>  getOrders(){
		return orderRepo.findAll();
	}
	
	@GetMapping("/getOrdersById/{id}")
	public ResponseEntity<Orders> getOrdersById(@PathVariable String id){
		Optional<Orders> opt =  orderRepo.findById(Integer.parseInt(id));
		return opt.isPresent() ?  new ResponseEntity<>(opt.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PostMapping("/updateOrderById")
	public @ResponseBody String updateOrderById(@RequestBody Orders order) {
		Optional<Orders> orderById = orderRepo.findById(order.getOrderId());

		if (orderById.isPresent()) {
			if ("DELIVERED".equals(order.getDeliveryStatus())) {
				Calendar cal = Calendar.getInstance();
				order.setDeliveryTimestamp(new Timestamp(cal.getTimeInMillis()));
			}
			UpdateUtil.copyNullProperties(order, orderById.get());
			orderRepo.save(orderById.get());
		}
		return "Order updated";
	}
	
	@DeleteMapping("/deleteOrderById/{id}")
	public @ResponseBody String deleteOrderById(@PathVariable String id) {
		orderRepo.deleteById(Integer.parseInt(id));
		return "Order deleted";
	}
}
