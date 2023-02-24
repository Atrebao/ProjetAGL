package com.projet.dao;

import java.util.List;

import com.projet.model.Client;
import com.projet.model.Transaction;

public interface ITransaction {
	
	void enregistrerTransaction(Transaction transaction);
	
	List<Transaction> getAllTransaction();
	
	List <Transaction> rechercherTransaction(Integer numTransaction);
	
	void supprimerTransaction(int id);
	
	void modifeirTransaction(Transaction transaction);

}
