package edu.mum.cs.cs544.exercise;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SetApp {

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
			
            Employee e1 = new Employee("Moustafa", "Bahnasawy");
            session.persist(e1);
            
           	Laptop l1 = new Laptop("HP", "Pavalion 15");
           	session.persist(l1);
           	
         	Laptop l2 = new Laptop("Macbook", "Pro Book 16 inch");
           	session.persist(l2);
           	
        	Laptop l3 = new Laptop("Macbook", "Pro Book 16 inch");
           	session.persist(l3);
           	
           	e1.addLaptop(l1);
           	e1.addLaptop(l2);
           	e1.addLaptop(l3);

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
            List<Employee> list = session.createQuery("from Employee").list();
            for (Employee e : list) {
                System.out.println("Employee:" +e.toString());
                System.out.println("has laptops");
                for(Laptop l: e.getLaptops()) {
                	System.out.println(l.toString());
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

		System.out.println("-------- Task 1 ---------------- ");
		task1();
		System.out.println("------------------------ ");

		System.out.println("-------- Task 2 ---------------- ");
		task2();
		System.out.println("------------------------ ");



		System.exit(0);
	}

}
