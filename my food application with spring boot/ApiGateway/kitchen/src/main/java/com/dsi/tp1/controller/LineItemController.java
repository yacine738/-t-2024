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

import com.dsi.tp1.entities.LineItem;
import com.dsi.tp1.services.ILineItemService;

@RestController
public class LineItemController {
	
	@Autowired
	private ILineItemService itemService;
	
	@GetMapping("/lineItems")
	public List<LineItem> getAll(){
		return itemService.allLineItems();
	}
	
	@GetMapping("/lineItems/{id}")
	public Optional<LineItem> getOne(@PathVariable("id") int id ) {
		return itemService.getLineItems(id);
	}
	
	@PostMapping("/lineItems")
	public LineItem createLineItems(@RequestBody LineItem item) {
		return itemService.addLineItems(item);
	}
	
	@PutMapping("/lineItems/{id}")
	public LineItem updateLineItems(@RequestBody LineItem item, @PathVariable("id") int id) {
		return itemService.updateLineItems(item,id);
	}
	
	@DeleteMapping("lineItems/{id}")
	public boolean deleteOne(@PathVariable("id")int id) {
		return itemService.deleteLineItems(id);
	}

}
