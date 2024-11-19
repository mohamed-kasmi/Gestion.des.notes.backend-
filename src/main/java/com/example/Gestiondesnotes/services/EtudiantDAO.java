package com.example.Gestiondesnotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Etudiant;
import com.example.Gestiondesnotes.repository.EtudiantRepository;

@Service
public class EtudiantDAO {
	@Autowired
	private EtudiantRepository etudiantcrud;
	public void save(Etudiant etudiant) {
		etudiantcrud.save(etudiant);
	}
	public void delete(int cinedutiant) {
		etudiantcrud.deleteById(cinedutiant);
	}
	public void update(int cin, Etudiant updateetud) {
        Etudiant existingEtudiant = etudiantcrud.findById(cin).orElseThrow(() -> 
            new RuntimeException("Note with cinetud " + cin + " not found"));
        existingEtudiant.setEmail(updateetud.getEmail());
        existingEtudiant.setPassword(updateetud.getPassword());
        etudiantcrud.save(existingEtudiant);
	}
}
