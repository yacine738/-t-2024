package com.dsi.tp1.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dsi.tp1.entities.Delivery;
import com.dsi.tp1.repositories.DeliveryRepository;

@Service

public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	DeliveryRepository deliveryRepository;

	@Override
	public Delivery noteDeliveryPickedUp(int id) {
		Optional<Delivery> l = deliveryRepository.findById(id);
		if(l.isPresent())
		{
			l.get().setStatus("pickedup");
			l.get().setScheduledPickupTime(LocalDateTime.now());
			return deliveryRepository.save(l.get());
		}
		
		return null;
	}

	@Override
	public Delivery noteDeliveryDelivered(int id) {
		Optional<Delivery> l = deliveryRepository.findById(id);
		if(l.isPresent())
		{
			l.get().setStatus("done");
			l.get().setScheduledDeliveryTime(LocalDateTime.now());
			return deliveryRepository.save(l.get());
		}
		return null;
	}

	@Override
	public Delivery noteDeliveryCanceled(int id) {
		Optional<Delivery> l = deliveryRepository.findById(id);
		if(l.isPresent())
		{
			l.get().setStatus("canceled");
	
			return deliveryRepository.save(l.get());
		}
		return null;
	}

	@Override
	public Delivery scheduleDelivery(int orderId) {
		return deliveryRepository.save(new Delivery( orderId, "pending", null, null ));
	}


}
