package com.example.Gestiondesnotes.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Matiere implements Serializable{//classe = Specialiter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String matiere;
	private String classe;
	private double cofi;
	public Matiere() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public double getCofi() {
		return cofi;
	}
	public void setCofi(double cofi) {
		this.cofi = cofi;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	
}
