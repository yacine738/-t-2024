package com.dsi.tp1.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class PayementInfo implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id_card;
@Temporal(TemporalType.DATE)
private LocalDate Date_validité;
private int Consumer_id;
@OneToMany(mappedBy = "payementInfo")
private Consumer consumer;

public PayementInfo() {
	super();
	// TODO Auto-generated constructor stub
}

public PayementInfo(int id_card, LocalDate date_validité, int consumer_id, Consumer consumer) {
	super();
	Id_card = id_card;
	Date_validité = date_validité;
	Consumer_id = consumer_id;
	this.consumer = consumer;
}

public int getId_card() {
	return Id_card;
}

public void setId_card(int id_card) {
	Id_card = id_card;
}

public LocalDate getDate_validité() {
	return Date_validité;
}

public void setDate_validité(LocalDate date_validité) {
	Date_validité = date_validité;
}

public int getConsumer_id() {
	return Consumer_id;
}

public void setConsumer_id(int consumer_id) {
	Consumer_id = consumer_id;
}

public Consumer getConsumer() {
	return consumer;
}

public void setConsumer(Consumer consumer) {
	this.consumer = consumer;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "PayementInfo [Id_card=" + Id_card + ", Date_validité=" + Date_validité + ", Consumer_id=" + Consumer_id
			+ ", consumer=" + consumer + "]";
}

}

