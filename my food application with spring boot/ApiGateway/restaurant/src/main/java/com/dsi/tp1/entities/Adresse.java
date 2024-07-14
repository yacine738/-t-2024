package com.dsi.tp1.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int numero;
	
	private String nom;
	
	private String rue;
	
	private String cite;
	
	private String ville;

	public Adresse(int numero, String nom, String rue, String cite, String ville) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.rue = rue;
		this.cite = cite;
		this.ville = ville;
	}

	public Adresse() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCite() {
		return cite;
	}

	public void setCite(String cite) {
		this.cite = cite;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
