package com.dsi.tp1.entities;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="deliveryInfo")
public class DeliveryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalTime deliveryTime;
	
	private int deliveryAdress;

	public DeliveryInfo(LocalTime deliveryTime, int deliveryAdress) {
		super();
		this.deliveryTime = deliveryTime;
		this.deliveryAdress = deliveryAdress;
	}

	public DeliveryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DeliveryInfo [id=" + id + ", deliveryTime=" + deliveryTime + ", deliveryAdress=" + deliveryAdress + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getDeliveryAdress() {
		return deliveryAdress;
	}

	public void setDeliveryAdress(int deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}
	
	
}
