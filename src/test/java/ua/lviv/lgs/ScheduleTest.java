package ua.lviv.lgs;

import java.util.TreeSet;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {

	private static Schedule scheduleTest;
	private static Movie movie;
	private static Movie movie1;
	private static Seance seance;
	private static Seance seance2;

	private static TreeSet<Seance> seances;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED-->" + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED-->" + description.getMethodName());
		};

	};

	@BeforeClass
	public static void beforeTest() {
		scheduleTest = new Schedule();
		movie = new Movie("Як тестувати TreeSet", new Time(1, 45));
		seance = new Seance(movie, new Time(15, 20));
		movie1 = new Movie("Як перевірити видалення TreeSet", new Time(0, 27));
		seance2 = new Seance(movie1, new Time(10, 17));
		seances = new TreeSet<Seance>();
		seances.add(seance);
		seances.add(seance2);

	}

	@AfterClass
	public static void afterTest() {
		scheduleTest = null;

	}

	// Тестуємо метод addSeance
	@Test
	public void addSeanceTest() {

		scheduleTest.addSeance(seance);
		scheduleTest.addSeance(seance2);
		Assert.assertEquals(seances, scheduleTest.getSeances());

	}
	

	// Тестуємо метод removeSeance
	@Test
	public void removeSeanceTest() {

		seances.remove(seance);
		scheduleTest.addSeance(seance);
		scheduleTest.addSeance(seance2);
		scheduleTest.removeSeance(seance);
		Assert.assertEquals(seances, scheduleTest.getSeances());

	}

}
