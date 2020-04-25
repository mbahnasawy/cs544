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

import edu.mum.cs.cs544.exercises.a.Customer;
import edu.mum.cs.cs544.exercises.a.Order;
import edu.mum.cs.cs544.exercises.a.OrderLine;
import edu.mum.cs.cs544.exercises.a.Product;

public class B_App {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/*
	 * • creating an object tree
	 * 
	 */
	public static void task1() {
		
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
            Customer c1 = new Customer("Moustafa", "Bahnasawy");
            session.persist(c1);
            
            Customer c2 = new Customer("Payman", "Salek");
            session.persist(c2);
            
           	Product p1 = new CD("Amr Diab", "Tamaly Maak");
           	session.persist(p1);
           	
         	Product p2 = new DVD("Pop", "Micheal Jakson");
           	session.persist(p2);
           	
         	Product p3 = new Book("Clean Code", "Published by author Jogn Smith"); 
           	session.persist(p3);
           	
           	OrderLine ol1 = new OrderLine(1, p1);
           	session.persist(ol1);
           	
           	OrderLine ol2 = new OrderLine(2, p2);
           	session.persist(ol2);
           	
           	OrderLine ol3 = new OrderLine(1, p3);
           	session.persist(ol3);
           	
        	OrderLine ol4 = new OrderLine(3, p1);
           	session.persist(ol4);
           	
     
           	Order o1 = new Order(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
           	session.persist(o1);
           	
           	o1.addOrderLine(ol1);
           	o1.addOrderLine(ol2);

           	Order o2 = new Order(new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2020"));
           	session.persist(o2);
           	
           	o2.addOrderLine(ol3);
           	
           	
         	Order o3 = new Order(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2020"));
           	session.persist(o3);
           	
           	o3.addOrderLine(ol4);
           	
           	
           	c1.addOrder(o1);
           	c1.addOrder(o3);
           	
           	c2.addOrder(o2);
           	
			tx.commit();

		} catch (HibernateException | ParseException  e) {
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
	 * Rretrieve the objects from the database to check if everything was persisted correctly.
	 */
	public static void task2() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
            @SuppressWarnings("unchecked")
            List<Customer> list = session.createQuery("from Customer").list();
            for (Customer c : list){
                System.out.println("Customer:" +c.toString());
                System.out.println("has Orders:");
                for(int orderId: c.getOrders().keySet()) {
                	System.out.println(c.getOrders().get(orderId).toString());
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
