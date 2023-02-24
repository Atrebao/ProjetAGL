package com.projet.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import com.projet.model.Reservation;
import com.projet.model.Transaction;
import com.projet.util.HibernateUtil;


public class TransactionDao implements ITransaction{

	@Override
	public void enregistrerTransaction(Transaction transac) {
		 org.hibernate.Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(transac);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }

				
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		 org.hibernate.Transaction transaction = null;
	        List < Transaction > transacs = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	            transacs = session.createQuery("from transaction").list();
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return transacs;
	}

	@Override
	public List<Transaction> rechercherTransaction(Integer numTransaction) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction transaction = null;
        List < Transaction > transacs = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
           // students = session.createQuery("from Student").list();
            transacs = session.createSQLQuery(numTransaction.toString()).addEntity(getClass()).list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		return null;
	}

	@Override
	public void supprimerTransaction(int id) {
		
		  org.hibernate.Transaction transact = null;
	        Reservation reservation = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transact =  session.beginTransaction();

	            reservation = session.get(Reservation.class, id);
	            // get student object
	            session.delete(reservation);
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            ( transact).commit();
	        } catch (Exception e) {
	            if (transact != null) {
	                ( transact).rollback();
	            }
	        }
		
	
	}
		// TODO Auto-generated method stub

	@Override
	public void modifeirTransaction(Transaction transact) {
		// TODO Auto-generated method stub
		 org.hibernate.Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.update(transact);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}
		

}
