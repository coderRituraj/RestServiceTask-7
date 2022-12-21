package com.bhavna.bean;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id
	private int id;
	private String orderCategory;
	private Date orderDate;
	private Date deliveryDate;
	private String orderStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCategory() {
		return orderCategory;
	}
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Orders(int id, String orderCategory, Date orderDate, Date deliveryDate, String orderStatus) {
		super();
		this.id = id;
		this.orderCategory = orderCategory;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderCategory=" + orderCategory + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + ", orderStatus=" + orderStatus + "]";
	}
	
	

}
