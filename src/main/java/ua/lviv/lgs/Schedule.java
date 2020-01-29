package ua.lviv.lgs;

import java.util.Set;
import java.util.TreeSet;

public class Schedule implements Comparable<Schedule> {

	Set<Seance> seances = new TreeSet<>();

	public Schedule(Set<Seance> seances) {
		super();
		this.seances = seances;
	}

	public Schedule() {

	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public void addSeance(Seance seance) {
		seances.add(seance);
	}

	public void removeSeance(Seance seance) {
		seances.remove(seance);
	}

	@Override
	public int compareTo(Schedule arg0) {

		return 0;
	}

	@Override
	public String toString() {
		return "Schedule [seances=" + seances + "]";
	}
	
	

}
