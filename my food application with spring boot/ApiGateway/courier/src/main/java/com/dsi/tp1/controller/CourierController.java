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

import com.dsi.tp1.entities.Courier;
import com.dsi.tp1.services.ICourierService;

@RestController
public class CourierController {
	
	@Autowired
	private ICourierService courierService;
	
	@GetMapping("/couriers")
	public List<Courier> getAll(){
		return courierService.getAll();
	}
	
	@GetMapping("/couriers/{cin}")
	public Optional<Courier> getOne(@PathVariable("cin") int id){
		return courierService.getCourier(id);
	}
	
	@PostMapping("/couriers")
	public Courier createCoutier(@RequestBody Courier c) {
		return courierService.addCourier(c);
	}
	
	@PutMapping("/couriers/{cin}")
	public Courier updateCourier(@RequestBody Courier c, @PathVariable("cin") int id) {
		return courierService.updateCourier(c, id);
	}
	
	@DeleteMapping("/couriers/{cin}")
	public boolean deleteOne(@PathVariable("cin") int id) {
		return courierService.deleteCourier(id);
	}

}
