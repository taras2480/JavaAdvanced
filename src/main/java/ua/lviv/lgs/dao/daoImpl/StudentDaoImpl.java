package ua.lviv.lgs.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.domain.Student;


public class StudentDaoImpl implements StudentDao {
	
	private List<Student> listStudents = new ArrayList<>();
	
	

	@Override
	public Student create(Student student) {
		
		listStudents.add(student);
		return student;
	}

	@Override
	public Student read(Integer id) {
		
		Student student=listStudents.get(id);
		
		return student;
	}

	@Override
	public Student update(Student student) {
		listStudents.remove(student.getId());
		listStudents.add(student);
		return student;
		
	}

	@Override
	public void delete(Integer id) {
		listStudents.remove(id);
		
	}

	@Override
	public List<Student> readAll() {
		
		return listStudents;
	}

}
