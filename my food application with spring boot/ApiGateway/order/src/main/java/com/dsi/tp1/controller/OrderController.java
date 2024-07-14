package com.dsi.tp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Order;
import com.dsi.tp1.services.OrderServiceImpl;


@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/test")
	public String test()
	{
		return "test from : " +env.getProperty("local.server.port");
	}
	
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order o)
	{
		return orderService.insert(o);
	}
	
	@PutMapping("/orders/{id}")
	public Order cancelOrder(@PathVariable("id") int id)
	{
		return orderService.cancel(id);
	}
}
