package cs544.exercise16_2;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("studentService")
@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService {
	@Autowired
	private StudentDAO studentdao;
	@Autowired
	private SessionFactory sessionFactory;

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	public void setSf(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public StudentService() {

	}

	public Student getStudent(long studentid) {
		Student s = studentdao.load(studentid);

		return s;
	}
}
