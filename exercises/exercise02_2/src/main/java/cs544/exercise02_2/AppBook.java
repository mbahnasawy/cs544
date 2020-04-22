package cs544.exercise02_2;

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

public class AppBook {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/*
	 * • Open a session • Create 3 books save them to the database • Close the
	 * session
	 * 
	 */
	public static void task1() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create new instance of book1 and set values in it
			Book book1 = new Book("Clean Code", "1111", "John", 12.5,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001"));
			// save the car
			session.persist(book1);

			// Create new instance of book1 and set values in it
			Book book2 = new Book("Chracking the Code interview", "2222", "Clinton", 40.0,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2005"));
			// save the car
			session.persist(book2);

			// Create new instance of book1 and set values in it
			Book book3 = new Book("History of c++", "3333", "Paul", 13.0,
					new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1995"));
			// save the car
			session.persist(book3);

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("Rolling back: " + e.getMessage());
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/*
	 * 
	 * Open a session • Retrieve all books and output them to the console • Close
	 * the session
	 */
	public static void task2() {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Retrieve all books
			@SuppressWarnings("unchecked")
			List<Book> bookList = session.createQuery("from Book").list();
			for (Book book : bookList) {
				System.out.println(book.toString());
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

	/*
	 * 
	 * Open a session • Retrieve a book from the database and change its title and
	 * price • Delete a book (not the one that was just updated) • Close the session
	 */
	public static void task3() {
		// Hibernate placeholder
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Retrieve a book from the database 
			Book book1 = (Book)session.get(Book.class, 1L); // 1 here it will be the Id of the generated book in task 1
			book1.setTitle("Clean Code version 2");
			book1.setPrice(14.0);
			
			// Delete a book from the database
			Book book2 = (Book)session.load(Book.class, 2L); // using load here to decrease database hits to be just 1 hit.
			session.delete(book2);
			
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
		
		System.out.println("-------- Task 3 ---------------- ");
		task3();
		System.out.println("------------------------ ");
	
		System.out.println("-------- Task 4 ---------------- ");
		task2(); // task4 is the same as task 2 (Retrieve all books) 
		System.out.println("------------------------ ");

		System.exit(0);
	}

}
