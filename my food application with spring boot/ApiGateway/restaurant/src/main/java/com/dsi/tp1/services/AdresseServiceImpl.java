package com.dsi.tp1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Adresse;
import com.dsi.tp1.repositories.AdresseRepository;

@Service
public class AdresseServiceImpl implements IAdresseService{
	
	@Autowired
	private AdresseRepository adresseRepository;

	@Override
	public Optional<Adresse> getAdresse(int i) {
		// TODO Auto-generated method stub
		return adresseRepository.findById(i);
	}

	@Override
	public List<Adresse> getAdresses() {
		// TODO Auto-generated method stub
		return adresseRepository.findAll();
	}

	@Override
	public Adresse addAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return adresseRepository.save(a);
	}

	@Override
	public Adresse updateAdresse(Adresse a, int i) {
		// TODO Auto-generated method stub
		Adresse adresse = adresseRepository.findById(i).get();
		a.setNumero(adresse.getNumero());
		return adresseRepository.save(a);
	}

	@Override
	public boolean deleteAdresse(int i) {
		// TODO Auto-generated method stub
		adresseRepository.deleteById(i);
		return !adresseRepository.existsById(i);
	}

	@Override
	public List<Adresse> findAvailableRestaurants(String ville) {
		// TODO Auto-generated method stub
		List<Adresse> allAdresses = this.getAdresses();
		List<Adresse> availableAdresses = new ArrayList<Adresse>();
		for (Adresse a : allAdresses) {
			if(a.getVille().equals(ville)) {
				availableAdresses.add(a);
			}
		}
		return availableAdresses;
	}
	

}
