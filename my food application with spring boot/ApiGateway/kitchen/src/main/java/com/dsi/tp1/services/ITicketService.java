package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import com.dsi.tp1.entities.Ticket;

public interface ITicketService {
	public List<Ticket> allTickets();
	public Optional<Ticket> getTicket(int i);
	public Ticket createTicket(Ticket t);
	public Ticket updateTicket(Ticket t, int i);
	public boolean deleteTicket(int i);
	public Ticket acceptTicket(int i);
	public Ticket readyForPickUp(int i);
}
