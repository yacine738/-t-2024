package com.dsi.tp1.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderLineItems")
public class OrderLineItems implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int quantite;
	
	private int idMenu;
	
	private int idOrder;

	public OrderLineItems(int quantite, int idMenu, int idOrder) {
		super();
		this.quantite = quantite;
		this.idMenu = idMenu;
		this.idOrder = idOrder;
	}

	public OrderLineItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderLineItems [id=" + id + ", quantite=" + quantite + ", idMenu=" + idMenu + ", idOrder=" + idOrder
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	
}
