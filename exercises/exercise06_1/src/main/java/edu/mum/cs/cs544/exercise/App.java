package edu.mum.cs.cs544.exercise;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/*
	 * • creates two laptops and set them to employee
	 * 
	 */
	public static void task1() {
		
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			//TODO 
			Patient p1 = new Patient("Moustafa", "1000 N 4th St", "52557", "Fairfield");
			session.persist(p1);
			
			Payment payment = new Payment("20/05/2020", 100.0);
			//session.persist(payment);
			
			Doctor d1 = new Doctor("Dentist", "Ahmed", "Yassen");
			session.persist(d1);
			
			Doctor d2 = new Doctor("Optical", "Hany", "Salek");
			session.persist(d2);
			
			Appointment a1 = new Appointment("21/05/2020", p1, payment, d1);
			session.persist(a1);
			
			Appointment a2 = new Appointment("22/05/2020", p1, payment, d2);
			session.persist(a2);
			
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
	 * Retrieve all employees with their own laptops
	 */
	public static void task2() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
            @SuppressWarnings("unchecked")
            List<Appointment> list = session.createQuery("from Appointment").list();
            for (Appointment a : list) {
                System.out.println(a.toString());
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

		System.out.println("-------- Task 1 ---------------- ");
		task1();
		System.out.println("------------------------ ");

		System.out.println("-------- Task 2 ---------------- ");
		task2();
		System.out.println("------------------------ ");



		System.exit(0);
	}

}
