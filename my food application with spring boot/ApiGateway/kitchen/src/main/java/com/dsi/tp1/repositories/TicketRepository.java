package com.dsi.tp1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.tp1.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
