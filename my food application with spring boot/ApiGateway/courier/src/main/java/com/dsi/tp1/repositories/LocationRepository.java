package com.dsi.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
