package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Location;
import com.dsi.tp1.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements ILocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Optional<Location> getLocation(int i) {
		// TODO Auto-generated method stub
		return locationRepository.findById(i);
	}

	@Override
	public List<Location> getLocations() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	@Override
	public Location addLocation(Location l) {
		// TODO Auto-generated method stub
		return locationRepository.save(l);
	}

	@Override
	public Location updateLocation(Location l, int i) {
		// TODO Auto-generated method stub
		Location location = locationRepository.findById(i).get();
		l.setId(location.getId());
		return locationRepository.save(l);
	}

	@Override
	public boolean deletLocation(int i) {
		// TODO Auto-generated method stub
		locationRepository.deleteById(i);
		return !locationRepository.existsById(i);
	}
	
	
	
}
