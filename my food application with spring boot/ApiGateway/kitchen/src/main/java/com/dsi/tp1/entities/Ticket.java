package com.dsi.tp1.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket implements Serializable{

	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String state;
	
	private int restaurantId; 
	
	private LocalDate preparingTime;
	
	private LocalDate pickedUpTime;

	public Ticket() {
	}
	
	public Ticket(String state, int restaurantId, LocalDate preparingTime, LocalDate pickedUpTime) {
		super();
		this.state = state;
		this.restaurantId = restaurantId;
		this.preparingTime = preparingTime;
		this.pickedUpTime = pickedUpTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public LocalDate getPreparingTime() {
		return preparingTime;
	}

	public void setPreparingTime(LocalDate preparingTime) {
		this.preparingTime = preparingTime;
	}

	public LocalDate getPickedUpTime() {
		return pickedUpTime;
	}

	public void setPickedUpTime(LocalDate pickedUpTime) {
		this.pickedUpTime = pickedUpTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
