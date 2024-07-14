package com.dsi.tp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Ticket;
import com.dsi.tp1.services.ITicketService;

@RestController
public class TicketController {

	@Autowired
	private ITicketService ticketService;
	
	@GetMapping("/tickets")
	public List<Ticket> getAll(){
		return ticketService.allTickets();
	}
	
	@GetMapping("/tickets/{id}")
	public Optional<Ticket> getOne(@PathVariable("id") int id ) {
		return ticketService.getTicket(id);
	}
	
	@PostMapping("/tickets")
	public Ticket createOrder(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}
	
	@PutMapping("/tickets/{id}")
	public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("id") int id) {
		return ticketService.updateTicket(ticket,id);
	}
	
	@DeleteMapping("tickets/{id}")
	public boolean deleteOne(@PathVariable("id")int id) {
		return ticketService.deleteTicket(id);
	}
	
	@PutMapping("/acceptTicket/{id}")
	public Ticket acceptTicket(@PathVariable("id") int id) {
		return ticketService.acceptTicket(id);
	}
	
	@PutMapping("/readyTicket/{id}")
	public Ticket readyTicket(@PathVariable("id") int id) {
		return ticketService.readyForPickUp(id);
	}
	
}
