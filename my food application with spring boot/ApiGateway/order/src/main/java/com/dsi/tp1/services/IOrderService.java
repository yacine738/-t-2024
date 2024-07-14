package com.dsi.tp1.services;

import com.dsi.tp1.entities.Order;

public interface IOrderService {
	
	public Order insert(Order o);
	public Order cancel(int id);
	public Order revise(Order o,int id);
}