package com.example.Gestiondesnotes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Gestiondesnotes.entity.Etudiant;
import com.example.Gestiondesnotes.entity.Notes;
import com.example.Gestiondesnotes.entity.Prof;
import com.example.Gestiondesnotes.repository.NoteRepository;

@Service
public class NoteDAO {
	@Autowired
	private NoteRepository noteRepository;
	public void save(Notes note) {
		noteRepository.save(note);
	}
	public List<Notes > getAllbycinetud(int cinetud) {
        return noteRepository.findAllByCinetud(cinetud);
    }
	public List<Notes > getAllbycinprof(int cinprof) {
        return noteRepository.findAllByCinprof(cinprof);
    }
	
	    public Notes addnote(int cinetud,int cinprof,String matiere,String classe,String type,double note) {
	        // Check if email already exists
	    	if (noteRepository.findByCinetudAndMatiereAndType(cinetud, matiere, type) != null) {
	            throw new IllegalArgumentException("Note is already registered");
	        }

	        // Create and save a new user
	        Notes newNote = new Notes();
	        newNote.setCinetud(cinetud);
	        newNote.setCinprof(cinprof);
	        newNote.setMatiere(matiere);
	        newNote.setClasse(classe);
	        newNote.setType(type);
	        newNote.setNote(note);
	        
	        return noteRepository.save(newNote);
	    }
	    public List<Notes> getallnotesbycinetudandprof(int cinetud,int cinprof){
	    	return noteRepository.findAllByCinetudAndCinprof(cinetud, cinprof);
	    }
	    public boolean updateNote(int id,Notes updatenote) {
		    Optional<Notes> optionalNotes = noteRepository.findById(id);

		    if (optionalNotes.isPresent()) {
		        // Get the existing Etudiant
		        Notes existingNote = optionalNotes.get();

		        // Update fields
		        existingNote.setCinetud(updatenote.getCinetud());
		        existingNote.setCinprof(updatenote.getCinprof());
		        existingNote.setMatiere(updatenote.getMatiere());
		        existingNote.setClasse(updatenote.getClasse());
		        existingNote.setType(updatenote.getType()); 
		        existingNote.setNote(updatenote.getNote()); 

		        // Save updated entity
		        noteRepository.save(existingNote);

		        // Return true to indicate successful update
		        return true;
		    }
		    // Return false if cin does not exist
		    return false;
		}
	    public void delete(int id) {
			 if (!noteRepository.existsById(id)) {
				 throw new RuntimeException("Etudiant not found");
				 }
			 noteRepository.deleteById(id);
		 }
	    // delete 
	
	

}
