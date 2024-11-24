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
	        Etudiant existingEtudiant = optionalEtudiant.get();
	        existingEtudiant.setNom(updateetud.getNom());
	        existingEtudiant.setPrenom(updateetud.getPrenom());
	        existingEtudiant.setGenre(updateetud.getGenre());
	        existingEtudiant.setEmail(updateetud.getEmail());
	        existingEtudiant.setPassword(updateetud.getPassword()); 
	        etudiantRepository.save(existingEtudiant);
	        return true;
	    }
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
	    	 return false; 
	     }
	     return etudiant.getPassword().equals(password); 
	 }
	 public Integer getCinetudByEmail(String email) {
	        return etudiantRepository.findCinetudByEmail(email);
	    }
	 public Etudiant addEtudbyadmin(int cin,String classe) {
	        if (getEtudById(cin) != null) {
	            throw new IllegalArgumentException("CIN is already registered");
	        }
	        Etudiant newEtud = new Etudiant();
	        newEtud.setCin(cin);
	        newEtud.setClasse(classe);
	        return etudiantRepository.save(newEtud);
	    }
	 public List<Etudiant> getAllEtudiant() {
	        return etudiantRepository.findAll();
	    }
}
