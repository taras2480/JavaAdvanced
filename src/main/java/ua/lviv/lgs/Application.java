package ua.lviv.lgs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Application {
	private static Scanner sc = new Scanner(System.in);
	private static Cinema cinema = new Cinema(new Time(10, 0), new Time(22, 0));
	
	

	public static void main(String[] args) {
		
		//Case 1 - writting warn, case 2,3 - written info,Class time - writting Error

		while (true) {
			System.out.println("Menu: ");
			System.out.println("натисніть 1, щоб додати фільм");
			System.out.println("Натисніть 2, щоб видаити фільм");
			System.out.println("Натисніть 3, щоб додати сеанс");
			System.out.println("Натисніть 4, щоб видалити сеанс");
			System.out.println("Натисніть 5, щоб побачити сеанси певного фільму");
			
			

			switch (sc.nextLine()) {

			case "1":
				Log.warn("Hours has not to be less then 0 or more then 24, minutes has not to be less then 0 or more then 60");
				Movie newMovie = newMovie();
				ArrayList<Time> seancesTime = new ArrayList<>();
				while (true) {
					System.out.println("Чи бажаєте додати ще сеанс даного фільму?('y' or 'n'):");
					String ind = sc.nextLine();
					if (ind.equals("n")) {
						break;
					} else if (ind.equals("y")) {
						System.out.println("Введіть час сеансу");
						Time time = new Time(sc.nextInt(), sc.nextInt());
						while (cinema.getOpen().compareTo(time) > 0 || cinema.getClose().compareTo(time) < 0) {
							System.out.println("На жаль, кінотеатр зачинено в такий час, введіть інший час");
							time = new Time(sc.nextInt(), sc.nextInt());
						}
						seancesTime.add(time);
						sc.nextLine();
					}

				}
				Time[] arrSeanceTime = new Time[seancesTime.size()];
				cinema.addMovie(newMovie, seancesTime.toArray(arrSeanceTime));
				Log.info("Додано один фільм"+newMovie);
				break;

			case "2":
				System.out.println("Виберіть фільм, щоб його видалити");

				cinema.removeMovie(chooseMovie());
				Log.info("Увага! Видалено фільм"+chooseMovie());
				break;
			
			case "4":
				System.out.println("Виберіть день, коли видалити сеанс");
				System.out.println(Arrays.toString(Days.values()));
				String ind = sc.nextLine();
				Schedule schedule = cinema.getSchedules().get(Days.valueOf(ind));
				System.out.println("Виберіть сеанс, щоб видалити");
				ArrayList<Seance> seanceList = new ArrayList<>(schedule.getSeances());
				for (int i = 0; i < seanceList.size(); i++) {
					System.out.println(i + " - " + seanceList.get(i));
				}
				int choise = sc.nextInt();
				sc.nextLine();
				Seance seanceDel = seanceList.get(choise);
				cinema.removeSeance(seanceDel, ind);

				break;
			case "5":
				System.out.println("Виберіть фільм, щоб показати його сеанси");
				Movie movieToShow = chooseMovie();
				for (int i = 0; i < Days.values().length; i++) {
					System.out.println(Days.values()[i]);
					cinema.getSchedules().get(Days.values()[i]).getSeances().stream()
							.filter(x -> x.getMovie().equals(movieToShow)).forEach(System.out::println);
					System.out.println("----------------------------------------");
				}
				break;

			}

		}
	}

	public static Movie newMovie() {
		System.out.println("Enter movie title:");
		String title = sc.nextLine();
		System.out.println("Enter movie duration (hours first then minutes):");
		Time duration = new Time(sc.nextByte(), sc.nextByte());
		sc.nextLine();

		return new Movie(title, duration);
	}

	public static Movie chooseMovie() {
		cinema.getMoviesLibrary().forEach(x -> System.out.println(x.getTitle()));
		String movieTitle = sc.nextLine();
		Movie movie = cinema.getMoviesLibrary().stream().filter(x -> x.getTitle().equalsIgnoreCase(movieTitle))
				.findFirst().get();
		return movie;
	}
}