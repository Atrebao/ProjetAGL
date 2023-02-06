package com.projet.dao;

import java.util.List;

import com.projet.model.Reservation;

public interface IReservation {
	
	void enregistrerReservation(Reservation reserv);
	
	Reservation verifierReservation(int numReserv);
	
	void modifierReservation(Reservation reserv);
	
	void supprimerReservation(int id);
	
	List<Reservation> getAllReservation();
	
	List <Reservation> rechercherReserv(int id);

}
