package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.TreeMap;

public class Cinema {

	private TreeMap<Days, Schedule> schedules;
	private ArrayList<Movie> moviesLibrary = new ArrayList<>();
	private Time open;
	private Time close;

	public Cinema() {
		
	}

	public Cinema(Time open, Time close) {
		schedules = new TreeMap<>();
		for (int i = 0; i < Days.values().length; i++) {
			schedules.put(Days.values()[i], new Schedule());
		}

		this.open = open;
		this.close = close;
	}

	public Cinema(TreeMap<Days, Schedule> schedules, ArrayList<Movie> moviesLibrary, Time open, Time close) {
		super();
		this.schedules = schedules;
		this.moviesLibrary = moviesLibrary;
		this.open = open;
		this.close = close;
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}
	

	public void setSchedules(TreeMap<Days, Schedule> schedules) {
		this.schedules = schedules;
	}

	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}

	public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
		this.moviesLibrary = moviesLibrary;
	}

	public Time getOpen() {
		return open;
	}

	public Time getClose() {
		return close;
	}

	public void addMovie(Movie movie, Time... time)  {

		moviesLibrary.add(movie);
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < Days.values().length; j++) {
				schedules.get(Days.values()[j]).addSeance(new Seance(movie, time[i]));
			}
		}

	}

	public void removeMovie(Movie ml) {

		moviesLibrary.remove(ml);

	}

	public void addSeance(Seance seance, String daySeance) {
		schedules.get(Days.valueOf(daySeance)).addSeance(seance);

	}

	public void removeSeance(Seance seance, String daySeance) {

		schedules.get(Days.valueOf(daySeance)).removeSeance(seance);
	}

	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + ", open=" + open + ", close="
				+ close + "]";
	}
}