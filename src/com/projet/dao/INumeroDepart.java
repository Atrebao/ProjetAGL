package com.projet.dao;

import java.util.List;

import com.projet.model.NumeroDepart;

public interface INumeroDepart {
	
	void saveNumeDepart(NumeroDepart num);
	
	 List<NumeroDepart> getAllNumerosDepart();

	 void deleteNumeroDepart(int id);

}
