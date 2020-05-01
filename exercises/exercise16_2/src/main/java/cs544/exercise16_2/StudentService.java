package cs544.exercise16_2;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
	private StudentDAO studentdao;

	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public StudentService() {
		Transaction tx = sf.getCurrentSession().beginTransaction();

		studentdao = new StudentDAO();
		Hibernate.initialize(studentdao);
		
		tx.commit();
	}

	public Student getStudent(long studentid) {
		Transaction tx = sf.getCurrentSession().beginTransaction();

		Student s = studentdao.load(studentid);
		Hibernate.initialize(s);
		for(Course c: s.getCourselist()) {
			Hibernate.initialize(c);
		}
		tx.commit();
		return s;
	}
}
