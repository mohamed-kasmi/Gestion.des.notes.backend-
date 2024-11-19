package com.example.Gestiondesnotes.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Matiere;
import com.example.Gestiondesnotes.repository.MatiereRepository;

@Service
public class MatiereDAO {
	@Autowired
	private MatiereRepository matierecrud;
	public void save(Matiere matiere) {
		matierecrud.save(matiere);
	}
	public void delete(int idmatiere) {
		matierecrud.deleteById(idmatiere);
	}
}
