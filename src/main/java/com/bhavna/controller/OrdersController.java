package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.bean.Orders;
import com.bhavna.service.OrderService;

@RestController
public class OrdersController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/home")
	public String welcome() {
		return "Welcome to the home!";
	}
	
	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody Orders order) {
		orderService.addOrder(order);
	}
	
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/getByCategory/{category}")
	public List<Orders> getByCategory(@PathVariable String category){
		return orderService.getOrdersByCategory(category);
	}

	@PutMapping("/updateOrder/{category}")
	public void updateOrder(@PathVariable String category, @RequestBody Orders order) {
		orderService.updateByCategory(order, category);
	}
	
	@PatchMapping("/updateOrderP/{category}")
	public void updateOrderByPatch(@PathVariable String category, @RequestBody Orders order) throws Exception {
		orderService.updateByCategoryP(order, category);
	}
	
	@DeleteMapping("/deleteByOrderCategory/{category}")
	public void deleteByCategory(@PathVariable String category) {
		orderService.removeByCategory(category);

	}
}
