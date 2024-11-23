package com.example.Gestiondesnotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestiondesnotes.entity.Matiere;
import com.example.Gestiondesnotes.services.MatiereDAO;

@RestController
@RequestMapping("/matiere")
public class MatiereController {
	@Autowired
	private MatiereDAO matiereDAO;
	@GetMapping("/getallmat")
    public ResponseEntity<List<Matiere>> getAllEtudiant() {
        List<Matiere> matiere = matiereDAO.getAllProfessors();
        return ResponseEntity.ok(matiere);
    }
	 @PostMapping("/addmatiere")
	 public ResponseEntity<String> addMatiere(
	            @RequestParam String matiere,@RequestParam String classe,@RequestParam double cof) {
	        try {
	            matiereDAO.addMatiere(matiere,classe,cof);
	            return ResponseEntity.ok("Matier added!");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());}
	        }
	@PutMapping("/updatematiere/{idmatiere}")
	public ResponseEntity<String> updateMatiere(@PathVariable int idmatiere, @RequestBody Matiere updateMatiere) {
	    boolean updated = matiereDAO.updateMatiere(idmatiere, updateMatiere);
	    if (updated) {
	        return ResponseEntity.ok("Etudiant updated successfully.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matiere not found.");
	    }}
	@DeleteMapping("/delete/{idmatiere}")
    public ResponseEntity<String> deleteMatiere(@PathVariable int idmatiere) {
        try {
            matiereDAO.delete(idmatiere);
            return ResponseEntity.ok("Matiere with id " + idmatiere + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Matiere with id " + idmatiere + " not found");
        }
    }
	  @GetMapping("/matierebyclasse")
	    public ResponseEntity<List<String>> getMatiereByClasse(@RequestParam String classe) {
	        List<String> matieres = matiereDAO.getMatiereByClasse(classe);
	        return ResponseEntity.ok(matieres);
	    }
}
