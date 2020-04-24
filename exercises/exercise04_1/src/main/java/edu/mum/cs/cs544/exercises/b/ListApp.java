package edu.mum.cs.cs544.exercises.b;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ListApp {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/*
	 * • creates two cars, and associates an owner with each one before persisting it
	 * 
	 */
	public static void task1() {

		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Passenger p1 = new Passenger("Moustafa");
			session.persist(p1);
			
            Flight f1 = new Flight("SV105", "Chicago", "Cidar Rapids", 
            		new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2020"));
            session.persist(f1);
            
            Flight f2 = new Flight("SV106", "Cidar Rapids", "Chicago", 
            		new SimpleDateFormat("dd/MM/yyyy").parse("18/05/2020"));
            session.persist(f2);
            
            p1.addFlight(f1);
            p1.addFlight(f2);
         
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} catch (ParseException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/*
	 * 
	 * Then when retrieving the cars also print the details of each owner
	 */
	public static void task2() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

            @SuppressWarnings("unchecked")
            List<Passenger> list = session.createQuery("from Passenger").list();
            for (Passenger p : list) {
                System.out.println(p.toString());
                System.out.println("His current flights are:");
                for(Flight f: p.getFlights()) {
                	System.out.println(f.toString());
                }
            }
            tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-------- Task 1 ---------------- ");
		task1();
		System.out.println("------------------------ ");

		System.out.println("-------- Task 2 ---------------- ");
		task2();
		System.out.println("------------------------ ");



		System.exit(0);
	}

}
