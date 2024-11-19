package com.example.Gestiondesnotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestiondesnotes.entity.Prof;
import com.example.Gestiondesnotes.services.ProfDAO;

@RestController
@RequestMapping("/login")
public class ProfController {
	@Autowired
	private ProfDAO profDAO;
	@GetMapping("/prof")
    public ResponseEntity<Prof> getUserByEmail(@RequestParam String email) {
        Prof prof = profDAO.getProfByEmail(email);
        if (prof == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prof);
    }
	 @PostMapping("/auth")
	    public ResponseEntity<String> loginProf(@RequestParam String email, @RequestParam String password) {
	        boolean isAuthenticated = profDAO.authenticateProf(email, password);
	        if (isAuthenticated) {
	            return ResponseEntity.ok("Authentication successful!");
	        }
	        return ResponseEntity.status(401).body("Invalid email or password.");
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
}
