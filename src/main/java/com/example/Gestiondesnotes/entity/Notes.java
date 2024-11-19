package com.example.Gestiondesnotes.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notes implements Serializable{
	@Id
	private int id;
	private int cinetud;
	private String matiere;
	private String type;
	private double note;
	public Notes() {
		
	}
	public int getCinetud() {
		return cinetud;
	}
	public void setCinetud(int cinetud) {
		this.cinetud = cinetud;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	
	
	
}
