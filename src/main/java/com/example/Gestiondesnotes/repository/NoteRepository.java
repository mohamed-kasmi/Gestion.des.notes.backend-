package com.example.Gestiondesnotes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Integer>{
	List<Notes> findAllByCinetud(int cinetud);
	List<Notes> findAllByCinprof(int cinprof);
	List<Notes> findAllByCinetudAndCinprof(int cinetud,int cinprof);
	 @Query("SELECT n FROM Notes n WHERE n.cinetud = :cinetud AND n.matiere LIKE %:matiere%")
	    List<Notes> findAllByCinetudAndMatiereLike(@Param("cinetud") int cinetud, @Param("matiere") String matiere);
	Notes findByCinetudAndMatiereAndType(int cinetud, String matiere, String type);
}
