package com.example.Gestiondesnotes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Matiere;


@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer>{
	Matiere findByMatiereAndClasse(String matiere,String classe);
	  @Query("SELECT m.matiere FROM Matiere m WHERE m.classe = :classe")
	    List<String> findMatiereByClasse(@Param("classe") String classe);
}
