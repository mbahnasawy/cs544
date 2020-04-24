package edu.mum.cs.cs544.exercises.d;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UnidirectionalOneToManyApp {

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
	public static void task1() throws ParseException {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Customer c1 = new Customer("Mostafa");
			session.persist(c1);
			
			Reservation r1 = new Reservation(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
			session.persist(r1);
			
			c1.addReservation(r1);
		

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

		     // retieve all cars
            @SuppressWarnings("unchecked")
            List<Customer> list = session.createQuery("from Customer").list();
            for (Customer c : list) {
                System.out.println(c.toString());
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

	public static void main(String[] args) throws ParseException {
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
