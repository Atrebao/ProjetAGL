package com.projet.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.projet.model.Administrateur;
import com.projet.model.Employe;
import com.projet.model.NumeroDepart;
import com.projet.model.Reservation;
import com.projet.model.Transaction;
import com.projet.model.Villes;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bd_projet_agl?characterEncoding=utf8&useConfigs=maxPerformance");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Reservation.class);
                configuration.addAnnotatedClass(com.projet.model.Client.class);
                configuration.addAnnotatedClass(Transaction.class);
                configuration.addAnnotatedClass(Employe.class);
                configuration.addAnnotatedClass(Administrateur.class);
                configuration.addAnnotatedClass(Villes.class);
                configuration.addAnnotatedClass(NumeroDepart.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
