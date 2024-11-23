package com.example.Gestiondesnotes.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Prof;
import com.example.Gestiondesnotes.repository.ProfRepository;


@Service
public class ProfDAO {
	@Autowired
	private ProfRepository profrepository;
	public void save(Prof prof) {
		profrepository.save(prof);
	}
	 public void delete(int cinprof) {
		 if (!profrepository.existsById(cinprof)) {
			 throw new RuntimeException("Professor not found");
			 }
		 profrepository.deleteById(cinprof);
	 }
	public Prof getProfByEmail(String email) {
        return profrepository.findByEmail(email);
    }
	public Prof getProfById(int cin) {
		return profrepository.findById(cin).orElse(null);
	}
	 public boolean authenticateProf(String email, String password) {
		 Prof prof = getProfByEmail(email);
	     if (prof == null) {
	    	 return false; // User not found
	 }
	     return prof.getPassword().equals(password); // Simple password check
	 }
	 public Prof addProf(int cin,String nom,String prenom,String gener, String email,String password) {
	        // Check if email already exists
	        if (getProfByEmail(email) != null || getProfById(cin) != null) {
	            throw new IllegalArgumentException("Email is already registered");
	        }

	        // Create and save a new user
	        Prof newProf = new Prof();
	        newProf.setCin(cin);
	        newProf.setNom(nom);
	        newProf.setPrenom(prenom);
	        newProf.setGener(gener);
	        newProf.setEmail(email);
	        newProf.setPassword(password);
	        
	        return profrepository.save(newProf);
	    }
	 public List<Prof> getAllProfessors() {
	        return profrepository.findAll();
	    }

}
