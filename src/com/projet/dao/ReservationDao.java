package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projet.model.Reservation;
import com.projet.util.HibernateUtil;

public class ReservationDao implements IReservation{

	@Override
	public void enregistrerReservation(Reservation reserv) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(reserv);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public Reservation verifierReservation(int numReserv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierReservation(Reservation reserv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerReservation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> rechercherReserv(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
