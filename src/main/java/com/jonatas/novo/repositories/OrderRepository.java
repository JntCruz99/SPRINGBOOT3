package com.jonatas.novo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonatas.novo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
