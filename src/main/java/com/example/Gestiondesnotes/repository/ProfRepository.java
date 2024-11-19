package com.example.Gestiondesnotes.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Prof;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Integer>{
	Prof findByEmail(String email);
}
