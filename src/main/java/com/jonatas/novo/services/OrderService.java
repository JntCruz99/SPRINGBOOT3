package com.jonatas.novo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonatas.novo.entities.Order;
import com.jonatas.novo.entities.enums.OrderStatus;
import com.jonatas.novo.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
		
	}
	
	public Order findById(Long id) {
		Optional<Order> obj =  repository.findById(id);
		return obj.get();
	}
	public Order create(Order order) {

	    if (order.getMoment() == null || order.getOrderstatus() == null || order.getClient() == null) {
	        throw new IllegalArgumentException("O pedido deve conter o momento, status e cliente.");
	    }
	    
	    order.setOrderstatus(OrderStatus.CANCELED);
	    
	    return repository.save(order);
	}
}
