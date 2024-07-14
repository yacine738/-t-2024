package com.dsi.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.OrderLineItems;

public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems,Integer > {

}
