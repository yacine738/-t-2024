package com.dsi.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
