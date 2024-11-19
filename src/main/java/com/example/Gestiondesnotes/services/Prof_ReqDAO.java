package com.example.Gestiondesnotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Prof_Req;
import com.example.Gestiondesnotes.repository.Prof_ReqRepository;

@Service
public class Prof_ReqDAO {
	@Autowired
	private Prof_ReqRepository profreqcrud;
	public void save(Prof_Req profeque) {
		profreqcrud.save(profeque);
	}
	public void delete(int cinprof) {
		profreqcrud.deleteById(cinprof);
	}
	
	
}
