package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.sevice.UniversityService;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService service = ctx.getBean(UniversityService.class);

		University university = new University();

		university.setName("KRAUZ");
		university.setLevel(5);
		university.setQtyInstitutes(3);
		university.setQtyStudents(3000);
		university.setAdress("Kryvyi Rig");

		// save user to DB
		service.save(university);

		University university2 = new University();

		university2.setName("NAU");
		university2.setLevel(7);
		university2.setQtyInstitutes(6);
		university2.setQtyStudents(10000);
		university2.setAdress("Kyiv");

		// save user to DB
		service.save(university2);

		University university3 = new University();

		university3.setName("LVI-Politech");
		university3.setLevel(4);
		university3.setQtyInstitutes(3);
		university3.setQtyStudents(6000);
		university3.setAdress("Lviv");

		// save user to DB
		service.save(university3);

		// read from data base
		System.out.println(service.findById((long) 2));

		// update from db
		University uniUpdate = service.findById((long) 3);
		uniUpdate.setLevel(9);
		service.update(uniUpdate);

		// delete
		service.deleteById((long) 4);

	}

}
