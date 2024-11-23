package com.example.Gestiondesnotes.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notes implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cinetud;
	private int cinprof;
	private String matiere;
	private String classe;
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
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getCinprof() {
		return cinprof;
	}
	public void setCinprof(int cinprof) {
		this.cinprof = cinprof;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
