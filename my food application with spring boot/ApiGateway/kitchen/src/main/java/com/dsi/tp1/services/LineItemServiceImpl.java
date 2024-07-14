package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.LineItem;
import com.dsi.tp1.repositories.LineItemRepository;

@Service
public class LineItemServiceImpl implements ILineItemService{
	
	@Autowired
	private LineItemRepository itemsRepository;

	@Override
	public Optional<LineItem> getLineItems(int i) {
		// TODO Auto-generated method stub
		return itemsRepository.findById(i);
	}

	@Override
	public List<LineItem> allLineItems() {
		// TODO Auto-generated method stub
		return itemsRepository.findAll();
	}

	@Override
	public LineItem addLineItems(LineItem l) {
		// TODO Auto-generated method stub
		return itemsRepository.save(l);
	}

	@Override
	public LineItem updateLineItems(LineItem l, int i) {
		// TODO Auto-generated method stub
		LineItem item = itemsRepository.findById(i).get();
		l.setId(item.getId());
		return itemsRepository.save(l);
	}

	@Override
	public boolean deleteLineItems(int i) {
		// TODO Auto-generated method stub
		itemsRepository.deleteById(i);
		return !itemsRepository.existsById(i);
	
	}
}
