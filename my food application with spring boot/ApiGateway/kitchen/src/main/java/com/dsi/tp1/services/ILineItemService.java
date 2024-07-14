package com.dsi.tp1.services;

import java.util.List;
import java.util.Optional;

import com.dsi.tp1.entities.LineItem;

public interface ILineItemService {
	
	public Optional<LineItem> getLineItems(int i);
	public List<LineItem> allLineItems();
	public LineItem addLineItems(LineItem l);
	public LineItem updateLineItems(LineItem l, int i);
	public boolean deleteLineItems(int i);

}
