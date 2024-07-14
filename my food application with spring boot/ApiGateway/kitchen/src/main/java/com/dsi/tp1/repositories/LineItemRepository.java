package com.dsi.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.LineItem;

public interface LineItemRepository extends JpaRepository<LineItem, Integer> {

}
