package cs544.exercise16_2;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory ;
	
	public void setSf(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	public StudentDAO() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		
		sessionFactory.getCurrentSession().persist(student);

	}

	public Student load(long studentid) {
		return (Student)sessionFactory.getCurrentSession().get(Student.class, studentid);
	}
}
