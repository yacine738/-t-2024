package com.dsi.tp1.services;

import com.dsi.tp1.entities.Delivery;

public interface IDeliveryService {
	public Delivery noteDeliveryPickedUp(int id);
	public Delivery noteDeliveryDelivered(int id);
	public Delivery noteDeliveryCanceled(int id);
	public Delivery scheduleDelivery(int orderId); 
}
