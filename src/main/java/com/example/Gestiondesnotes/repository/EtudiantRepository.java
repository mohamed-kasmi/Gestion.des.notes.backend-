package com.example.Gestiondesnotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	Etudiant findByEmail(String email);
	@Query("SELECT e.cin FROM Etudiant e WHERE e.email = :email")
	Integer findCinetudByEmail(@Param("email") String email);
}
