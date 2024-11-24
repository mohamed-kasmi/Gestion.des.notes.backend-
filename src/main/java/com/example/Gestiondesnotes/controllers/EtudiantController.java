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

import com.example.Gestiondesnotes.entity.Etudiant;
import com.example.Gestiondesnotes.services.EtudiantDAO;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantDAO etudiantDAO;
	@GetMapping("/getalletud")
	public ResponseEntity<List<Etudiant>> getAllEtudiant() {
		List<Etudiant> etudiant = etudiantDAO.getAllEtudiant();
	    return ResponseEntity.ok(etudiant);
		}
	 @GetMapping("/cin-by-email")
	    public ResponseEntity<?> getCinprofByEmail(@RequestParam String email) {
	        Integer cinprof = etudiantDAO.getCinetudByEmail(email);

	        if (cinprof != null) {
	            return ResponseEntity.ok(cinprof);
	        } else {
	            return ResponseEntity.status(404).body("No Etudiant found with email: " + email);
	        }
	    }
	@PutMapping("/signup/{cin}")
	public ResponseEntity<String> updateEtudiant(@PathVariable int cin, @RequestBody Etudiant updatedEtudiant) {
	    boolean updated = etudiantDAO.updateEtud(cin, updatedEtudiant);
	    if (updated) {
	        return ResponseEntity.ok("Etudiant updated successfully.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudiant not found.");
	    }
	}
	 @PostMapping("/addetudbyadmin")
	 public ResponseEntity<String> addEtude(
	            @RequestParam int cin,@RequestParam String classe) {
	        try {
	            etudiantDAO.addEtudbyadmin(cin,classe);
	            return ResponseEntity.ok("Sign up successful!");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 @PostMapping("/login")
	    public ResponseEntity<String> loginEtud(@RequestParam String email, @RequestParam String password) {
	        boolean isAuthenticated = etudiantDAO.authenticateEtud(email, password);
	        if (isAuthenticated) {
	            return ResponseEntity.ok("Authentication successful!");
	        }
	        return ResponseEntity.status(401).body("Invalid email or password.");
	    }
	 @DeleteMapping("/delete/{cinetud}")
	    public ResponseEntity<String> deleteEtudiant(@PathVariable int cinetud) {
	        try {
	            etudiantDAO.delete(cinetud);
	            return ResponseEntity.ok("Student with CIN " + cinetud + " deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(404).body("Student with CIN " + cinetud + " not found");
	        }
	    }
	
	 

}
