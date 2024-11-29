package com.example.Gestiondesnotes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Notes;
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
	 public List<Notes> getallnotesbycinetudandprof(int cinetud,int cinprof){
	    	return noteRepository.findAllByCinetudAndCinprof(cinetud, cinprof);
	 	}
	 public List<Notes> findAllByCinetudAndMatiereLike(int cinetud, String matiere) {
	        return noteRepository.findAllByCinetudAndMatiereLike(cinetud, matiere);
	    }
	 public Notes addnote(int cinetud,int cinprof,String matiere,String classe,String type,double note) {
		 if (noteRepository.findByCinetudAndMatiereAndType(cinetud, matiere, type) != null) {
	            throw new IllegalArgumentException("Note is already registered");
	     	}
    	Notes newNote = new Notes();
        newNote.setCinetud(cinetud);
        newNote.setCinprof(cinprof);
        newNote.setMatiere(matiere);
        newNote.setClasse(classe);
        newNote.setType(type);
        newNote.setNote(note);
        	return noteRepository.save(newNote);
	    }
    public boolean updateNote(int id,Notes updatenote) {
	    Optional<Notes> optionalNotes = noteRepository.findById(id);
	    if (optionalNotes.isPresent()) {
	        Notes existingNote = optionalNotes.get();
	        existingNote.setType(updatenote.getType()); 
	        existingNote.setNote(updatenote.getNote()); 
	        noteRepository.save(existingNote);
	        return true;
	    	}
    	return false;
		}
    public void delete(int id) {
		 if (!noteRepository.existsById(id)) {
			 throw new RuntimeException("Etudiant not found");
			 }
		 noteRepository.deleteById(id);
    	}
}
