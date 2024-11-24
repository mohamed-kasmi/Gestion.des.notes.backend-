package com.example.Gestiondesnotes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Prof;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Integer>{
	Prof findByEmail(String email);
	@Query("SELECT p.cin FROM Prof p WHERE p.email = :email")
	Integer findCinprofByEmail(@Param("email") String email);
}
