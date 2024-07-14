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

import com.dsi.tp1.entities.Menu;
import com.dsi.tp1.services.IMenuService;

@RestController
public class MenuController {
	@Autowired
	private IMenuService menuService;
	
	@GetMapping("/menues")
	public List<Menu> getAll(){
		return menuService.getMenus();
	}
	
	@GetMapping("/menues/{id}")
	public Optional<Menu> getOne(@PathVariable("id")int id ){
		return menuService.getMenu(id);
	}
	
	@PostMapping("/menues")
	public Menu addMenu(@RequestBody Menu m) {
		return menuService.addMenu(m);
	}
	
	@PutMapping("/menues/{id}")
	public Menu updateMenu(@RequestBody Menu m,@PathVariable("id") int i) {
		return menuService.updateMenu(m, i);
	}
	
	@DeleteMapping("/menues/{id}")
	public boolean deleteMenu(@PathVariable("id")int i) {
		return menuService.deleteMenu(i);
	}
	
	
	@GetMapping("/menu")
	public List<Menu> getMenues(@RequestParam("cle") String cle) {
		return menuService.findRestaurantMenu(cle);
	}
	
	
	
	
}
