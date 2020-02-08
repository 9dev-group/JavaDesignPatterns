package design.pattern.dao.example1;

import java.util.List;

public interface BookDao {
	List<Book> getAllBooks();
	Book getBookByIsbn(int isbn);
	void saveBook(Book book);
	void deleteBook(Book book);
}
