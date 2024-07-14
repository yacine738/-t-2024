package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import com.dsi.tp1.entities.Adresse;

public interface IAdresseService {
	
	public Optional<Adresse> getAdresse(int i);
	public List<Adresse> getAdresses();
	public Adresse addAdresse(Adresse a);
	public Adresse updateAdresse(Adresse a,int i);
	public boolean deleteAdresse(int i);
	public List<Adresse> findAvailableRestaurants(String ville);

}
