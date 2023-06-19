package com.jonatas.novo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonatas.novo.entities.Order;
import com.jonatas.novo.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){

		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> finAll(@PathVariable Long id){
		
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	    Order createdOrder = service.create(order);
	    return ResponseEntity.ok().body(createdOrder);
	}
	

	
}
