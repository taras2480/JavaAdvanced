package ua.lviv.lgs.shared;

import java.util.List;

import ua.lviv.lgs.domain.Student;

public interface AbstractCrud<T> {

	Student create(Student student);

	Student read(Integer id);

	Student update(Student student);

	void delete(Integer id);
	
	List<Student> readAll();

	

}