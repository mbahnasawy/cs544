package edu.mum.cs.cs544.exercises.f;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class BidirectionalManyToOneApp {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/*
	 * • creates two cars, and associates an owner with each one before persisting
	 * it
	 * 
	 */
	public static void task1() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Department d1 = new Department("HR");
			session.persist(d1);
			
			Office f1 = new Office("223", "140");
			session.persist(f1);

			Employee e1 = new Employee("Moustafa");
			session.persist(e1);

			d1.addEmployee(e1);
			f1.addEmployee(e1);

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
			List<Department> dList = session.createQuery("from Department").list();
			for (Department d : dList) {
				System.out.println("Departement:" + d.getName());
				System.out.println("Include Employees");
				for (Employee e : d.getEmployees()) {
					System.out.println("Emplyee " + e.getName() + " who is working at building " + e.getOffice().getBuildingNumber());
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
