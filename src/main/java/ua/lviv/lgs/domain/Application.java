package ua.lviv.lgs.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.dao.StudentDao;



@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		Student student = (Student) ctx.getBean("student");
		StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
		ConsoleEventLogger consoleEventLogger = (ConsoleEventLogger) ctx.getBean("consoleEventLogger");
		
consoleEventLogger.logEvent("create " + studentDao.create(student).toString());
		
		

		consoleEventLogger.logEvent("Read first student ---> " + studentDao.read(0).toString());

		
		consoleEventLogger.logEvent("Read all Students ---> " + studentDao.readAll());
		
		consoleEventLogger.logEvent("Read all Students ---> " + studentDao.update(new Student(1,"Petro",44)));
		
		studentDao.delete(0);
		
		consoleEventLogger.logEvent("Read all Students ---> " + studentDao.readAll());
		
	}

}
