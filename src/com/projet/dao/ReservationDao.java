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
		 Transaction transaction = null;
	        Reservation reservation = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    reservation= session.byId(Reservation.class).getReference(numReserv);
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        
	        return reservation;
	}

	@Override
	public void modifierReservation(Reservation reserv) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(reserv);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public void supprimerReservation(int id) {
		// TODO Auto-generated method stub
		  Transaction transaction = null;
	        Reservation reservation = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            reservation = session.get(Reservation.class, id);
	            // get student object
	            session.delete(reservation);
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		
	        
	        
		 Transaction transaction = null;
	        List < Reservation> reservations = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	            reservations = session.createQuery("from Reservation").list();
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return reservations;
		
	}

	@Override
	public List<Reservation> rechercherReserv(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
