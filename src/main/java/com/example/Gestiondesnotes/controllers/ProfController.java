package com.example.Gestiondesnotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestiondesnotes.entity.Prof;
import com.example.Gestiondesnotes.services.ProfDAO;

@RestController
@RequestMapping("/prof")
public class ProfController {
	@Autowired
	private ProfDAO profDAO;
	@GetMapping("/checkifexsit")
    public ResponseEntity<Prof> getUserByEmail(@RequestParam String email) {
        Prof prof = profDAO.getProfByEmail(email);
        if (prof == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prof);
    }
	 @PostMapping("/login")
	    public ResponseEntity<String> loginProf(@RequestParam String email, @RequestParam String password) {
	        boolean isAuthenticated = profDAO.authenticateProf(email, password);
	        if (isAuthenticated) {
	            return ResponseEntity.ok("Authentication successful!");
	        }
	        return ResponseEntity.status(401).body("Invalid email or password.");
	    }
	 @GetMapping("/checkemail")
	    public ResponseEntity<String> checkIfEmailExists(@RequestParam String email) {
	        Prof professor = profDAO.getProfByEmail(email);

	        if (professor != null) {
	            return ResponseEntity.ok("Professor with email " + email + " exists.");
	        } else {
	            return ResponseEntity.status(404).body("Professor with email " + email + " does not exist.");
	        }
	    }
	 @PostMapping("/signup")
	    public ResponseEntity<String> signUpProf(
	            @RequestParam int cin,
	            @RequestParam String nom,
	            @RequestParam String prenom,
	            @RequestParam String gener,
	            @RequestParam String email,
	            @RequestParam String password) {
	        try {
	            profDAO.addProf(cin,nom,prenom,gener,email,password);
	            return ResponseEntity.ok("Sign up successful!");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 @DeleteMapping("/delete/{cinprof}")
	    public ResponseEntity<String> deleteProfessor(@PathVariable int cinprof) {
	        try {
	            profDAO.delete(cinprof);
	            return ResponseEntity.ok("Professor with CIN " + cinprof + " deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(404).body("Professor with CIN " + cinprof + " not found");
	        }
	    }
	 @GetMapping("/getallprof")
	    public ResponseEntity<List<Prof>> getAllProfessors() {
	        List<Prof> professors = profDAO.getAllProfessors();
	        return ResponseEntity.ok(professors);
	    }
	 @GetMapping("/prof/{cin}")
	 public ResponseEntity<Prof> getProfById(@PathVariable int cin) {
	     Prof prof = profDAO.getProfById(cin);
	     return prof != null ? ResponseEntity.ok(prof) : ResponseEntity.notFound().build();
	 }
}
