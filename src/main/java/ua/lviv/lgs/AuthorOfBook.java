package ua.lviv.lgs;

public class AuthorOfBook {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String birthday;
	
	public AuthorOfBook(int id, String first_name, String last_name, String email, String birthday) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.birthday = birthday;
	}

	public AuthorOfBook(String first_name, String last_name, String email, String birthday) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "AuthorOfBook [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	
	
	
	
	

}
