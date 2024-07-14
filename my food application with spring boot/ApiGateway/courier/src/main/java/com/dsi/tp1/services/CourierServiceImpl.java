package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Courier;
import com.dsi.tp1.repositories.CourierRepository;

@Service
public class CourierServiceImpl implements ICourierService {
	
	@Autowired
	private CourierRepository courierRepository;

	@Override
	public Optional<Courier> getCourier(int i) {
		// TODO Auto-generated method stub
		return courierRepository.findById(i);
	}

	@Override
	public List<Courier> getAll() {
		// TODO Auto-generated method stub
		return courierRepository.findAll();
	}

	@Override
	public Courier addCourier(Courier c) {
		// TODO Auto-generated method stub
		return courierRepository.save(c);
	}

	@Override
	public Courier updateCourier(Courier c, int i) {
		// TODO Auto-generated method stub
		Courier courier = courierRepository.findById(i).get();
		c.setCin(courier.getCin());
		return courierRepository.save(c);
	}

	@Override
	public boolean deleteCourier(int i) {
		// TODO Auto-generated method stub
		courierRepository.deleteById(i);
		return !courierRepository.existsById(i);
	}

}
