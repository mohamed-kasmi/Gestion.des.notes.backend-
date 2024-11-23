package com.example.Gestiondesnotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Admin;
import com.example.Gestiondesnotes.repository.AdminRepository;

@Service
public class AdminDAO {
	@Autowired
	private AdminRepository admincrud;
	
}
