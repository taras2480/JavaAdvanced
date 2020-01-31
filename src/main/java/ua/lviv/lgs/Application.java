package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		System.out.println("Таблиця Author\n $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

		AuthorOfBookDao authorOfBookDao = new AuthorOfBookDao(ConnectionUtils.openConnection());

		// READ-ALL
		authorOfBookDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		List<AuthorOfBook> listOfauthorOfBook = new ArrayList<>();

		listOfauthorOfBook.add(new AuthorOfBook("Михайло", "Булгаков", "ще не було", "1891-05-12"));
		listOfauthorOfBook.add(new AuthorOfBook("Василь", "Шкляр", "shklo@ukr.net", "1951-06-10"));

			// INSERT
			listOfauthorOfBook.forEach(authorOfBook -> {
				try {
					authorOfBookDao.insert(authorOfBook);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});

		authorOfBookDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// READ-ById
		AuthorOfBook authorOfBookBD = authorOfBookDao.read(5);
		System.out.println(authorOfBookBD);

		// UPDATE - ById
		authorOfBookBD.setLast_name(authorOfBookBD.getLast_name() + "-DeLordRossi");
		authorOfBookDao.update(authorOfBookBD);

		// READ-ALL
		authorOfBookDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		
		// DELETE Не працює, оскільки база даних взята з мого уроку по MySQL, а дана таблиця є
		// батьківська
		
		authorOfBookDao.delete(4);
	
		authorOfBookDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		System.out.println("Таблиця Book\n $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

		BookDao bookDao = new BookDao(ConnectionUtils.openConnection());

		// READ-ALL
		bookDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		List<Book> listBook = new ArrayList<>();

		listBook.add(new Book("Кря-кря", "дитяча", 50, "978-617-12-0092-013", 20));
		listBook.add(new Book("Червона книга", "наукова", 700, "978-617-12-0092-02", 16));

		// INSERT - не працює, оскільки використана таблиця є дочірна з існуючої бази данних, складена під час навчання по MySql
		listBook.forEach(book -> {
			try {
				bookDao.insert(book);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		bookDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// READ-ById
		Book bookBD = bookDao.read(5);
		System.out.println(bookBD);

				// UPDATE - ById
				bookBD.setName(bookBD.getName() + "-DeLordRossi");
				bookDao.update(bookBD);
			
//				
				bookDao.readAll().forEach(System.out::println);
						System.out.println("************************************************\n");

		// Delete - теж не працює через повязані таблиці

		bookDao.delete(4);
		// READ-ALL
				bookDao.readAll().forEach(System.out::println);
				System.out.println("************************************************\n");

		System.out.println("Таблиця Genre\n $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

		GenreDao genreDao = new GenreDao(ConnectionUtils.openConnection());

		// READ-ALL
		genreDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// Insert
		List<Genre> listGenre = new ArrayList<>();

		listGenre.add(new Genre("Наука"));
		listGenre.add(new Genre("Спорт"));

		listGenre.forEach(genre -> {
			try {
				genreDao.insert(genre);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		genreDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// READ-ById
		Genre genreBD = genreDao.read(5);
		System.out.println(genreBD);

		// UPDATE - ById
		genreBD.setName(genreBD.getName() + "-DeLordRossi");
		genreDao.update(genreBD);

		genreDao.readAll().forEach(System.out::println);
		System.out.println("************************************************\n");

		// Delete

		genreDao.delete(4);

	}

}
