package ua.lviv.lgs;

public class Time {

	private int min;
	private int hour;
	
	

	public Time() {
		
	}

	public Time(int hours, int min) throws IllegalArgumentException {
		if ((min < 0 || min > 60) || (hours < 0 || hours > 24)) {
			throw new IllegalArgumentException();
		} else {
			this.min = min;
			this.hour = hours;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public static Time sumTime(Time time1, Time time2) throws IllegalArgumentException {
		int hour = time1.getHour() + time2.getHour();
		int min = time1.getMin() + time2.getMin();

		if (min >= 60) {
			hour = hour + 1;
			min = min - 60;
		} if (hour >= 24) {
			hour = hour - 24;
		}

		return new Time(hour, min);
	}

	

	public int compareTo(Time o) {
		return (hour * 60 + min) - (o.getHour() * 60 + o.getMin());
	}

	@Override
	public String toString() {
		return hour + " год.:" + min + " хв.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

}
