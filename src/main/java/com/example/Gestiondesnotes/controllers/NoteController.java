package com.example.Gestiondesnotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestiondesnotes.entity.Notes;
import com.example.Gestiondesnotes.services.NoteDAO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/note")
public class NoteController {
	@Autowired
	private NoteDAO noteDAO;
	@GetMapping("/getallbycinetude")
	public ResponseEntity<List<Notes>> getallbycinetude(@RequestParam int cinetud) {
		List<Notes> notes = noteDAO.getAllbycinetud(cinetud);
	    return ResponseEntity.ok(notes);
	}
	@GetMapping("/getallbycinprof")
	public ResponseEntity<List<Notes>> getallbycinprof(@RequestParam int cinprof) {
		List<Notes> notes = noteDAO.getAllbycinprof(cinprof);
	    return ResponseEntity.ok(notes);
	}
	@GetMapping("/searchmatiereedtud")
    public ResponseEntity<List<Notes>> findNotesByCinetudAndMatiere(
            @RequestParam int cinetud,
            @RequestParam String matiere) {
        List<Notes> notes = noteDAO.findAllByCinetudAndMatiereLike(cinetud, matiere);
        return ResponseEntity.ok(notes);
    }
	@PostMapping("/addnotes")
    public ResponseEntity<String> addnotes(
            @RequestParam int cinetud,
            @RequestParam int cinprof,
            @RequestParam String matiere,
            @RequestParam String classe,
            @RequestParam String type,
            @RequestParam double note) {
        try {
            noteDAO.addnote(cinetud,cinprof,matiere,classe,type,note);
            return ResponseEntity.ok("Note added successful!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	@GetMapping("/shearchaddnote")
	public ResponseEntity<List<Notes>> getallnotesbycinetudandprof(@RequestParam int cinetud,@RequestParam int cinprof) {
		List<Notes> notes = noteDAO.getallnotesbycinetudandprof(cinetud,cinprof);
	    return ResponseEntity.ok(notes);
	}
	@PutMapping("/updateNote/{id}")
	public ResponseEntity<String> updateNote(@PathVariable int id, @RequestBody Notes updatedNote) {
	    boolean updated = noteDAO.updateNote(id, updatedNote);
	    if (updated) {
	        return ResponseEntity.ok("Note updated successfully.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudiant not found.");
	    }
	}
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletenote(@PathVariable int id) {
        try {
            noteDAO.delete(id);
            return ResponseEntity.ok("Note with ID " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Note with ID " + id + " not found");
        }
    }
	

}
