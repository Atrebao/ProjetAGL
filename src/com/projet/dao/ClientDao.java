package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projet.model.Client;
import com.projet.util.HibernateUtil;

public class ClientDao implements IClient{

	@Override
	public void enregistrerClient(Client client) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(client);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		  Transaction transaction = null;
	        List < Client > clients = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	            clients = session.createQuery("from client").list();
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return clients;
		
	}

	@Override
	public List<Client> rechercherReserv(Integer codeReser) {
		
		Transaction transaction = null;
        List < Client > clients = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
           // students = session.createQuery("from Student").list();
            clients = session.createSQLQuery(codeReser.toString()).addEntity(getClass()).list();
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
	public void modifierReservation(Client client) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(client);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public void supprimerClient(int id) {
		// TODO Auto-generated method stub
		  Transaction transaction = null;
	        Client client = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            client = session.get(Client.class, id);
	            // get student object
	            session.delete(client);
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

}
