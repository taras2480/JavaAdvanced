package ua.lviv.lgs;

public class Seance implements Comparable<Seance> {

	private Movie movie;
	private Time startTime;
	private Time endTime;
	
	

	public Seance() {
		super();
	}

	public Seance(Movie movie, Time startTime, Time endTime) throws IllegalArgumentException {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = Time.sumTime(startTime, movie.getDuration());
	}

	public Seance(Movie movie, Time startTime) throws IllegalArgumentException {
		super();
		this.movie = movie;
		this.startTime = startTime;

	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Seance o) {
		return startTime.compareTo(o.getStartTime());
	}

	@Override
	public String toString() {
		return "Seance [movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
