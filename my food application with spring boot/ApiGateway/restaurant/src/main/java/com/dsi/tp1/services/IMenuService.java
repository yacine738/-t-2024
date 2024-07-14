package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import com.dsi.tp1.entities.Menu;

public interface IMenuService {
	
	public Optional<Menu> getMenu(int i);
	public List<Menu> getMenus();
	public Menu addMenu(Menu m);
	public Menu updateMenu(Menu m, int i);
	public boolean deleteMenu(int i);
	public List<Menu> findRestaurantMenu(String cle);
}
