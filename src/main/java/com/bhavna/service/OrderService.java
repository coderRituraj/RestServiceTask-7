package com.bhavna.service;

import java.util.List;

import com.bhavna.bean.Orders;

public interface OrderService {
	
	public void addOrder(Orders order);
	
	public List<Orders> getAllOrders();
	
	public List<Orders> getOrdersByCategory(String category);
	
	public void removeByCategory(String category);
	
	public void updateByCategory(Orders order, String category);
	
	public void updateByCategoryP(Orders order, String category) throws Exception;
}
