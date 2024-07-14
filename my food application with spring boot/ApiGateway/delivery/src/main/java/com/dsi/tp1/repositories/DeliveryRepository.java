package com.dsi.tp1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsi.tp1.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}

