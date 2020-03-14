package ua.lviv.lgs.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.dao.daoImpl.StudentDaoImpl;
import ua.lviv.lgs.domain.ConsoleEventLogger;
import ua.lviv.lgs.domain.Student;



@Configuration
public class CustomConfiguration {
	
	@Bean(name = "student")
	public Student getStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Taras");
		student.setAge(25);
		return student;
	}
	

	@Bean(name = "studentDao")
	public StudentDao getStudentDao() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao;
	}
	
	@Bean(name = "consoleEventLogger")
	public ConsoleEventLogger getConsoleEventLogger() {
		return new ConsoleEventLogger();

	}
	
	

	
	
	

}
