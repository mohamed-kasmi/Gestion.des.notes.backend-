package com.example.Gestiondesnotes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Etudiant;
import com.example.Gestiondesnotes.repository.EtudiantRepository;

@Service
public class EtudiantDAO {
	@Autowired
	private EtudiantRepository etudiantRepository;
	public void save(Etudiant etudiant) {
		etudiantRepository.save(etudiant);
	}
	 public void delete(int cinetud) {
		 if (!etudiantRepository.existsById(cinetud)) {
			 throw new RuntimeException("Etudiant not found");
			 }
		 etudiantRepository.deleteById(cinetud);
	 }
	public boolean updateEtud(int cin,Etudiant updateetud) {
	    Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(cin);

	    if (optionalEtudiant.isPresent()) {
	        // Get the existing Etudiant
	        Etudiant existingEtudiant = optionalEtudiant.get();

	        // Update fields
	        existingEtudiant.setNom(updateetud.getNom());
	        existingEtudiant.setPrenom(updateetud.getPrenom());
	        existingEtudiant.setGenre(updateetud.getGenre());
	        existingEtudiant.setEmail(updateetud.getEmail());
	        existingEtudiant.setPassword(updateetud.getPassword()); 

	        // Save updated entity
	        etudiantRepository.save(existingEtudiant);

	        // Return true to indicate successful update
	        return true;
	    }
	    // Return false if cin does not exist
	    return false;
	}

	public Etudiant getEtudByEmail(String email) {
        return etudiantRepository.findByEmail(email) ;
    }
	
	public Etudiant getEtudById(int cin) {
		return etudiantRepository.findById(cin).orElse(null);
	}
	 public boolean authenticateEtud(String email, String password) {
		 Etudiant etudiant = getEtudByEmail(email);
	     if (etudiant == null) {
	    	 return false; // User not found
	     }
	     return etudiant.getPassword().equals(password); // Simple password check
	 }
	 public Etudiant addEtudbyadmin(int cin,String classe) {
	        // Check if email already exists
	        if (getEtudById(cin) != null) {
	            throw new IllegalArgumentException("CIN is already registered");
	        }
	        // Create and save a new user
	        Etudiant newEtud = new Etudiant();
	        newEtud.setCin(cin);
	        newEtud.setClasse(classe);
	        return etudiantRepository.save(newEtud);
	    }
	 public List<Etudiant> getAllEtudiant() {
	        return etudiantRepository.findAll();
	    }
}
