package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Ticket;
import com.dsi.tp1.repositories.TicketRepository;

@Service
public class TicketServiceImpl implements ITicketService {
	
	@Autowired
	private TicketRepository ticketrepository;

	@Override
	public Ticket createTicket(Ticket t) {
		// TODO Auto-generated method stub
		return ticketrepository.save(t);
	}

	@Override
	public List<Ticket> allTickets() {
		// TODO Auto-generated method stub
		return ticketrepository.findAll();
	}

	@Override
	public Optional<Ticket> getTicket(int i) {
		// TODO Auto-generated method stub
		return ticketrepository.findById(i);
	}

	@Override
	public Ticket updateTicket(Ticket t, int i) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketrepository.findById(i).get();
		t.setId(ticket.getId());
		return ticketrepository.save(t);
	}

	@Override
	public boolean deleteTicket(int i) {
		// TODO Auto-generated method stub
		ticketrepository.deleteById(i);
		return !ticketrepository.existsById(i);
	}

	@Override
	public Ticket acceptTicket(int i) {
		// TODO Auto-generated method stub
		Ticket t = ticketrepository.findById(i).get();
		t.setState("accepted");
		return ticketrepository.save(t);
	}

	@Override
	public Ticket readyForPickUp(int i) {
		// TODO Auto-generated method stub
		Ticket t = ticketrepository.findById(i).get();
		t.setState("ready");
		return ticketrepository.save(t);
	}

}
