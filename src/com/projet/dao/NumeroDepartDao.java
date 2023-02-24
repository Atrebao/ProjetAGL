package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projet.model.NumeroDepart;
import com.projet.util.HibernateUtil;


public class NumeroDepartDao implements INumeroDepart{

	@Override
	public void saveNumeDepart(NumeroDepart num) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(num);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public List<NumeroDepart> getAllNumerosDepart() {
		// TODO Auto-generated method stub
		List < NumeroDepart > numerosDepart = null;
		 Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           // start the transaction
           transaction = session.beginTransaction();

           // get students
           numerosDepart = session.createQuery("from NumeroDepart").list();
           //student = session.load(Student.class, id);
           // commit the transaction
           transaction.commit();
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
       }
       return numerosDepart;
		
		
	}

	@Override
	public void deleteNumeroDepart(int id) {
		// TODO Auto-generated method stub
		
		 Transaction transaction = null;
	        NumeroDepart numeroDepart = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            numeroDepart = session.get(NumeroDepart.class, id);
	            // get student object
	            session.delete(numeroDepart);
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
