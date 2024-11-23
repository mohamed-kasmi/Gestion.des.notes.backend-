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

import com.example.Gestiondesnotes.entity.Prof_Req;
import com.example.Gestiondesnotes.services.Prof_ReqDAO;

@RestController
@RequestMapping("/profreq")
public class Prof_ReqController {
	@Autowired
	private Prof_ReqDAO prof_ReqDAO;
    @GetMapping("/checkemail")
    public ResponseEntity<String> checkIfEmailExists(@RequestParam String email) {
        Prof_Req professor = prof_ReqDAO.getProfByEmail(email);

        if (professor != null) {
            return ResponseEntity.ok("Professor with email " + email + " exists.");
        } else {
            return ResponseEntity.status(404).body("Professor with email " + email + " does not exist.");
        }
    }
	 @PostMapping("/signuprforeq")
	    public ResponseEntity<String> signUpProf(
	            @RequestParam int cin,
	            @RequestParam String nom,
	            @RequestParam String prenom,
	            @RequestParam String gener,
	            @RequestParam String email,
	            @RequestParam String password) {
	        try {
	        	prof_ReqDAO.addProf(cin,nom,prenom,gener,email,password);
	            return ResponseEntity.ok("Sign up successful!");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 @DeleteMapping("/delete/{cinprof}")
	    public ResponseEntity<String> deleteProfreq(@PathVariable int cinprof) {
	        try {
	            prof_ReqDAO.delete(cinprof);
	            return ResponseEntity.ok("Professor with CIN " + cinprof + " deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(404).body("Professor with CIN " + cinprof + " not found");
	        }
	    }
	 @GetMapping("/checkcin")
	 public ResponseEntity<String> checkIfIdExists(@RequestParam int id) {
	        Prof_Req professor = prof_ReqDAO.getProfById(id);

	        if (professor != null) {
	            return ResponseEntity.ok("Professor with ID " + id + " exists.");
	        } else {
	            return ResponseEntity.status(404).body("Professor with ID " + id + " does not exist.");
	        }
	    }
	 @GetMapping("/getallprofreq")
	    public ResponseEntity<List<Prof_Req>> getAllProfessors() {
	        List<Prof_Req> professorsreq = prof_ReqDAO.getAllProfessorsreq();
	        return ResponseEntity.ok(professorsreq);
	    }
	 
}
