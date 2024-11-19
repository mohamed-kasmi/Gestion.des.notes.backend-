package com.example.Gestiondesnotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Notes;
import com.example.Gestiondesnotes.repository.NoteRepository;

@Service
public class NoteDAO {
	@Autowired
	private NoteRepository notecrude;
	public void save(Notes note) {
		notecrude.save(note);
	}
	

}
