package com.dsi.tp1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Delivery;
import com.dsi.tp1.services.IDeliveryService;


@RestController
public class DeliveryController {
	
	@Autowired
	IDeliveryService deliveryService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/test")
	public String test()
	{
		return "test from : " +env.getProperty("local.server.port");
	}
	
	@PostMapping("/scheduleDelivery/{orderId}")
	public Delivery scheduleDelivery(@PathVariable("orderId") int orderId)
	{
		return deliveryService.scheduleDelivery(orderId);
	}
	
	@PutMapping("/deliveryPickedUp/{id}")
	public Delivery noteDeliveryPickedUp(@PathVariable("id") int id)
	{
		return deliveryService.noteDeliveryPickedUp(id);
	}
	
	@PutMapping("/deliveryDelivered/{id}")
	public Delivery noteDeliveryDelivered(@PathVariable("id") int id)
	{
		return deliveryService.noteDeliveryDelivered(id);
	}
	
	@PutMapping("/deliveryCanceled/{id}")
	public Delivery noteDeliveryCanceled(@PathVariable("id") int id)
	{
		return deliveryService.noteDeliveryCanceled(id);
	}

}

