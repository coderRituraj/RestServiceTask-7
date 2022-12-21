package com.bhavna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavna.bean.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	Orders findByOrderCategory(String category);
	
}
