package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import com.dsi.tp1.entities.Courier;

public interface ICourierService {

	public Optional<Courier> getCourier(int i);
	public List<Courier> getAll();
	public Courier addCourier(Courier c);
	public Courier updateCourier(Courier c, int i);
	public boolean deleteCourier(int i);
}
