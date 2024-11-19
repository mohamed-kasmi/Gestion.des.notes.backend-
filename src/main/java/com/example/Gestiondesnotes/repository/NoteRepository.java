package com.example.Gestiondesnotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Integer>{

}
