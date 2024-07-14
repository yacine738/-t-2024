package com.dsi.tp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Location;
import com.dsi.tp1.services.ILocationService;

@RestController
public class LocationController {
	
	@Autowired
	private ILocationService locationService;
	
	@GetMapping("/locations")
	public List<Location> getAll(){
		return locationService.getLocations();
	}
	
	@GetMapping("/locations/{id}")
	public Optional<Location> getOne(@PathVariable("id")int id){
		return locationService.getLocation(id);
	}
	
	@PostMapping("/locations")
	public Location addLocation(@RequestBody Location l) {
		return locationService.addLocation(l);
	}
	
	@PutMapping("/locations/{id}")
	public Location updateLocation(@RequestBody Location l,@PathVariable("id")int id) {
		return locationService.updateLocation(l, id);
	}
	
	@DeleteMapping("/locations/{id}")
	public boolean deleteLocation(@PathVariable("id") int id) {
		return locationService.deletLocation(id);
	}

}
