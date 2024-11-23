package com.example.Gestiondesnotes.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Matiere;
import com.example.Gestiondesnotes.repository.MatiereRepository;

@Service
public class MatiereDAO {
	@Autowired
	private MatiereRepository matiereRepository;
	public void delete(int idmatiere) {
		 if (!matiereRepository.existsById(idmatiere)) {
			 throw new RuntimeException("Matiere not found");
			 }
		 matiereRepository.deleteById(idmatiere);
	 }
	public Matiere getmatiername(String matiere,String classe) {
        return matiereRepository.findByMatiereAndClasse(matiere,classe);
    }
	public Matiere addMatiere(String matiere,String classe,double cof) {
        if (getmatiername(matiere,classe) != null) {
            throw new IllegalArgumentException("Matiere is already exist");
        }
        Matiere newMatiere = new Matiere();
        newMatiere.setMatiere(matiere);
        newMatiere.setClasse(classe);
        newMatiere.setCofi(cof);
        return matiereRepository.save(newMatiere);
    }
	public boolean updateMatiere(int idmatiere,Matiere updateemat) {
	    Optional<Matiere> optionalMatiere = matiereRepository.findById(idmatiere);

	    if (optionalMatiere.isPresent()) {
	        Matiere existingMatiere = optionalMatiere.get();
	        existingMatiere.setMatiere(updateemat.getMatiere());
	        existingMatiere.setClasse(updateemat.getClasse());
	        existingMatiere.setCofi(updateemat.getCofi());
	        matiereRepository.save(existingMatiere);
	        return true;
	    }
	    return false;
	}
 public List<Matiere> getAllProfessors() {
        return matiereRepository.findAll();
    }
 public List<String> getMatiereByClasse(String classe) {
        return matiereRepository.findMatiereByClasse(classe);
    }
	
}
