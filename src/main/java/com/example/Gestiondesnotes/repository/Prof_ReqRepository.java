package com.example.Gestiondesnotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestiondesnotes.entity.Prof_Req;

@Repository
public interface Prof_ReqRepository extends JpaRepository<Prof_Req, Integer>{

}
