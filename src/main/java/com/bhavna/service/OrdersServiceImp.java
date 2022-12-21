package com.bhavna.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.bean.Orders;
import com.bhavna.repository.OrdersRepository;

@Service
public class OrdersServiceImp implements OrderService{
	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public void addOrder(Orders order) {
		// TODO Auto-generated method stub
		ordersRepository.save(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return ordersRepository.findAll();
	}

	@Override
	public void removeByCategory(String category) {
		// TODO Auto-generated method stub
		ordersRepository.findAll().stream().forEach((s)->{
			if(s.getOrderCategory().contentEquals(category)) {
				ordersRepository.deleteById(s.getId());
		}});
	}

	@Override
	public void updateByCategory(Orders order,String category) {
		// TODO Auto-generated method stub
		ordersRepository.findAll().stream().forEach((s)->{
			if(s.getOrderCategory().contentEquals(category)) {
				ordersRepository.save(order);
		}});
	}

	@Override
	public List<Orders> getOrdersByCategory(String category) {
		// TODO Auto-generated method stub
		return ordersRepository.findAll().stream().filter(s->s.getOrderCategory().contentEquals(category)).collect(Collectors.toList());
	}
/*
	@Override
	public void updateByCategoryP(Orders order, String category) {
		// TODO Auto-generated method stub
		ordersRepository.findAll().stream().forEach((s)->{
			if(s.getOrderCategory().contentEquals(category)) {
				ordersRepository.save(order);
		}});
		
	}
	*/
	public void updateByCategoryP(Orders order, String Category) throws Exception{
		    Orders o1=ordersRepository.findByOrderCategory(Category);
		    if(o1.getOrderCategory().contentEquals(Category)) {
		    	o1.setDeliveryDate(order.getDeliveryDate());
		    	o1.setId(order.getId());
		    	o1.setOrderCategory(order.getOrderCategory());
		    	o1.setOrderDate(o1.getOrderDate());
		    	o1.setOrderStatus(order.getOrderStatus());
		    	ordersRepository.save(o1);
		    }else {
		    	throw new Exception("Resouce not found");
		    }		 
	}


}
