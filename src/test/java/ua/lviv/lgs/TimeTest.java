package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	private Time timeTest;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED-->" + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED-->" + description.getMethodName());
		};

	};

	@Before
	public void beforeTest() {
		timeTest = new Time();

	}

	@After
	public void afterTest() {
		timeTest = null;

	}

	// Тестуємо конструктор з параматерами класу Time на предмет спрацювання
	// IllegalArgumentException. Якщо ввести години менше 24,хвилини спрацьовує
	// FAILED,що також довдить коректність умови, прописаної в конструкторі
	@Test(expected = IllegalArgumentException.class)
	public void timeWithExceptionTest() {
		int hours = -1;
		int min = -15;
		timeTest = new Time(hours, min);

		int expectedTime = -2;

		Assert.assertEquals(expectedTime, timeTest);

	}

	 // Даний тест спрацьовує тільки при часі 0,0, оскільки початкова ініціалізація
			// за замовчуванням 0
	
	@Test
	public void timeCorrect() {
		int hours = 0;
		int min = 0;
		Time expectedTime = new Time(hours, min);

		Assert.assertEquals(expectedTime, timeTest);

	}
	

	// тестуємо метод sumTime.Знайшов помилку, до речі)) - зайве else було,спеціально
			// виділив великим шрифтом, має бути без нього

	// if (min >= 60) {
	// hour = hour + 1;
	// min = min - 60;
    //} ELSE if (hour >= 24) {
	// hour = hour - 24;}
   
	@Test 
	public void timeSumTest() {

		Time realTime = Time.sumTime(new Time(18, 40), new Time(21, 36));
		Time expectedTime = new Time(16, 16);

		Assert.assertEquals(expectedTime, realTime);
	}
	
	//тестуємо метод sumTime на предмет викидання помилки IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void timeSumTestWithExceptionTest() {

		Time realTime = Time.sumTime(new Time(39, 15), new Time(21, 69));
		Time expectedTime = new Time(16, 16);

		Assert.assertEquals(expectedTime, realTime);
	}

}
