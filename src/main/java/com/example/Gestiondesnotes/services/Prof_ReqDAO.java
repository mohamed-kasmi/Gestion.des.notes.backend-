package com.example.Gestiondesnotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Prof_Req;
import com.example.Gestiondesnotes.repository.Prof_ReqRepository;

@Service
public class Prof_ReqDAO {
	@Autowired
	private Prof_ReqRepository prof_ReqRepository;
	public void delete(int cinprof) {
		 if (!prof_ReqRepository.existsById(cinprof)) {
			 throw new RuntimeException("Professor not found");
			 }
		 prof_ReqRepository.deleteById(cinprof);
	 }
	
	public Prof_Req getProfByEmail(String email) {
        return prof_ReqRepository.findByEmail(email);
    }
	public Prof_Req getProfById(int cin) {
		return prof_ReqRepository.findById(cin).orElse(null);
	}
	 public Prof_Req addProf(int cin,String nom,String prenom,String gener, String email,String password) {
	        // Check if email already exists
	        if (getProfByEmail(email) != null || getProfById(cin) !=null) {
	            throw new IllegalArgumentException("your are already registered");
	        }
	        // Create and save a new user
	        Prof_Req newProf = new Prof_Req();
	        newProf.setCin(cin);
	        newProf.setNom(nom);
	        newProf.setPrenom(prenom);
	        newProf.setGener(gener);
	        newProf.setEmail(email);
	        newProf.setPassword(password);
	        return prof_ReqRepository.save(newProf);
	    }
	 public List<Prof_Req> getAllProfessorsreq() {
	        return prof_ReqRepository.findAll();
	    }
}
