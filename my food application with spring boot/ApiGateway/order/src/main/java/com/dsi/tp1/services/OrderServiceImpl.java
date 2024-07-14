package com.dsi.tp1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Order;
import com.dsi.tp1.repositories.*;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order insert(Order o) {
		return orderRepository.save(o);

	}
	@Override
	public Order cancel(int id) {
		Order order = orderRepository.findById(id).get();
        order.setState("canceled");
        return orderRepository.save(order);	
	}

	@Override
	public Order revise(Order o, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
