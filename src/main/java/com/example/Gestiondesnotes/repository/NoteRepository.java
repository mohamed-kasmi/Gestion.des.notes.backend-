package com.example.Gestiondesnotes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Integer>{
	List<Notes> findAllByCinetud(int cinetud);
	List<Notes> findAllByCinprof(int cinprof);
	List<Notes> findAllByCinetudAndCinprof(int cinetud,int cinprof);
	Notes findByCinetudAndMatiereAndType(int cinetud, String matiere, String type);
}
