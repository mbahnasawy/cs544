package edu.mum.cs.cs544.exercises.c;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MapApp {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/*
	 * 
	 * Create School and students
	 */
	public static void task1() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			School sc1 = new School("Maharishi School");
			session.persist(sc1);
			
            Student s1 = new Student("Moustafa", "Bahnasawy");
            session.persist(s1);
            
            Student s2 = new Student("Ahmed", "Yassen");
            session.persist(s2);
            
            Student s3 = new Student("Payman", "Salek");
            session.persist(s3);
 
            sc1.addStudentToSchool(s1);
            sc1.addStudentToSchool(s2);
            sc1.addStudentToSchool(s3);
            
            School sc2 = new School("Harvard School");
			session.persist(sc2);
			
			sc2.addStudentToSchool(s2);

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
	 * Retrieve school and students
	 */
	public static void task2() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

            @SuppressWarnings("unchecked")
            List<School> list = session.createQuery("from School").list();
            for (School s : list) {
                System.out.println(s.toString());
                System.out.println(" has the following students");
                for(int stID: s.getStudents().keySet()) {
                	System.out.println(s.getStudents().get(stID).toString());
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
