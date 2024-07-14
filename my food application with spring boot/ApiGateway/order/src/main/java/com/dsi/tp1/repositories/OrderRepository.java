package com.dsi.tp1.repositories;

import com.dsi.tp1.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
