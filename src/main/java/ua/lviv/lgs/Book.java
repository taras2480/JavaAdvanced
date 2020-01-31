package ua.lviv.lgs;

public class Book {
	
	private int id;
	private String name;
	private String description;
	private int price;
	private String isbn;
	private int genre_id;
	
	
	
	public Book(int id, String name, String description, int price, String isbn, int genre_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.genre_id = genre_id;
	}
	public Book(String name, String description, int price, String isbn, int genre_id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.genre_id = genre_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", isbn="
				+ isbn + ", genre_id=" + genre_id + "]";
	}
	
	

}
