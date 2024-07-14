package com.dsi.tp1.entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Consumer implements Serializable{
	
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id;
private String Nom;
private String Telephone;
private String Adresse_mail;
@ManyToOne
private PayementInfo payementInfo;

public Consumer() {
	super();
}

public Consumer(int id, String nom, String telephone, String adresse_mail, PayementInfo payementInfo) {
	super();
	Id = id;
	Nom = nom;
	Telephone = telephone;
	Adresse_mail = adresse_mail;
	this.payementInfo = payementInfo;
}

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}

public String getTelephone() {
	return Telephone;
}

public void setTelephone(String telephone) {
	Telephone = telephone;
}

public String getAdresse_mail() {
	return Adresse_mail;
}

public void setAdresse_mail(String adresse_mail) {
	Adresse_mail = adresse_mail;
}

public PayementInfo getPayementInfo() {
	return payementInfo;
}

public void setPayementInfo(PayementInfo payementInfo) {
	this.payementInfo = payementInfo;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "Consumer [Id=" + Id + ", Nom=" + Nom + ", Telephone=" + Telephone + ", Adresse_mail=" + Adresse_mail
			+ ", payementInfo=" + payementInfo + "]";
}



}


