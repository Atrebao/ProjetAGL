package com.projet.dao;

import java.util.List;

import com.projet.model.Employe;

public interface IEmploye {
	void ajouterEmploye(Employe empl);
	
	void supprimerEmploye(int id);
	
	void modifierEmploye(Employe empl);
	
	List<Employe> getAllEmploye();
	
	List <Employe> rechercher(String nom);

}
