package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import com.dsi.tp1.entities.Location;

public interface ILocationService {
	
	public Optional<Location> getLocation(int i);
	public List<Location> getLocations();
	public Location addLocation(Location l);
	public Location updateLocation(Location l , int i);
	public boolean deletLocation(int i);

}
