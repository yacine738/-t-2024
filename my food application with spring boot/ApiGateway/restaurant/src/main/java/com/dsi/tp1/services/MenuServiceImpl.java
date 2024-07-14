package com.dsi.tp1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Menu;
import com.dsi.tp1.repositories.MenuRepository;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public Optional<Menu> getMenu(int i) {
		// TODO Auto-generated method stub
		return menuRepository.findById(i);
	}

	@Override
	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Menu addMenu(Menu m) {
		// TODO Auto-generated method stub
		return menuRepository.save(m);
	}

	@Override
	public Menu updateMenu(Menu m, int i) {
		// TODO Auto-generated method stub
		Menu menu = menuRepository.findById(i).get();
		m.setId(menu.getId());
		return menuRepository.save(m);
	}

	@Override
	public boolean deleteMenu(int i) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(i);
		return !menuRepository.existsById(i);
	}

	@Override
	public List<Menu> findRestaurantMenu(String cle) {
		// TODO Auto-generated method stub
		List<Menu> list = this.getMenus();
		List<Menu> res = new ArrayList<Menu>();
		for (Menu menu:list) {
			if (menu.getNom().contains(cle)) {
				res.add(menu);
			}
		}
		return res;
	}

}
