package com.dsi.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

}
