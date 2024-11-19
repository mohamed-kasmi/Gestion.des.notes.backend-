package com.example.Gestiondesnotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestiondesnotes.entity.Admin;
import com.example.Gestiondesnotes.repository.AdminRepository;

@Service
public class AdminDAO {
	@Autowired
	private AdminRepository admincrud;
	public void save(Admin admin) {
		admincrud.save(admin);
	}
	public void delete(int idadmin) {
		admincrud.deleteById(idadmin);
	}
	// Update an existing Note (void)
    public void update(int id, Admin updateadmin) {
        Admin existingNote = admincrud.findById(id).orElseThrow(() -> 
            new RuntimeException("Note with cinetud " + id + " not found"));
        existingNote.setEmail(updateadmin.getEmail());
        existingNote.setPassword(updateadmin.getPassword());
        admincrud.save(existingNote);
    }
}
