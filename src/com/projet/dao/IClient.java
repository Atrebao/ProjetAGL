package com.projet.dao;

import java.util.List;

import com.projet.model.Client;

public interface IClient {
	
	void enregistrerClient(Client client);
	
	List<Client> getAllClient();
	
	List <Client> rechercherReserv(Integer codeReser);
	
	void modifierReservation(Client client);
	
	void supprimerClient(int id);

}
