package com.example.Gestiondesnotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

}
