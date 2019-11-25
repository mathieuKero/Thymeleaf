package com.thymeleaf.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Ordinateur {

	private String nom;
	private String processeur;
	private String ram;
	private String disqueDur;
	private Date dateAchat;
	
	public Ordinateur() {
		
	}

	public Ordinateur(String nom, String processeur, String ram, String disqueDur, Date dateAchat) {
		super();
		this.nom = nom;
		this.processeur = processeur;
		this.ram = ram;
		this.disqueDur = disqueDur;
		this.dateAchat = dateAchat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getDisqueDur() {
		return disqueDur;
	}

	public void setDisqueDur(String disqueDur) {
		this.disqueDur = disqueDur;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
}
