package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projet.model.Villes;
import com.projet.util.HibernateUtil;


public class VilleDao implements IVillle{

	@Override
	public void saveVille(Villes ville) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(ville);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public List<Villes> getAllVilles() {
		// TODO Auto-generated method stub
		List < Villes > villes = null;
		 Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            villes = session.createQuery("from Villes").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return villes;
		
	}

	@Override
	public void deleteVille(int id) {
		// TODO Auto-generated method 

		 Transaction transaction = null;
	        Villes ville = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            ville = session.get(Villes.class, id);
	            // get student object
	            session.delete(ville);
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
