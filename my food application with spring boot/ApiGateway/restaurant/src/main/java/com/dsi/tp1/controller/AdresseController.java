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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Adresse;
import com.dsi.tp1.services.IAdresseService;

@RestController
public class AdresseController {
	
	@Autowired
	private IAdresseService adresseService;
	
	@GetMapping("/adresses")
	public List<Adresse> getAll(){
		return adresseService.getAdresses();
	}
	
	@GetMapping("/adresses/{id}")
	public Optional<Adresse> getOne(@PathVariable("id") int n){
		return adresseService.getAdresse(n);
	}
	
	@PostMapping("/adresses")
	public Adresse addAdresse(@RequestBody Adresse a) {
		return adresseService.addAdresse(a);
	}
	
	@PutMapping("/adresses/{id}")
	public Adresse updateAdresse(@RequestBody Adresse a,@PathVariable("id") int n) {
		return adresseService.updateAdresse(a, n);
	}
	
	@DeleteMapping("/adresses/{id}")
	public boolean deleteOne(@PathVariable("id")int n) {
		return adresseService.deleteAdresse(n);
	}
	
	@GetMapping("/adresse")
	public List<Adresse> getMenues(@RequestParam("ville") String ville) {
		return adresseService.findAvailableRestaurants(ville);
	}

}
