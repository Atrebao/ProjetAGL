package com.projet.dao;

import java.util.List;

import com.projet.model.Villes;

public interface IVillle {
	
	void saveVille(Villes ville);
	
	 List<Villes> getAllVilles();

	 void deleteVille(int id);
	 

}
