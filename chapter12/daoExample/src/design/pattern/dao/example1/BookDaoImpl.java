package design.pattern.dao.example1;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{

	//DB 접속 대신 데이터 저장
	private List<Book> books;
	
	public BookDaoImpl() {
		books = new ArrayList<Book>();
		books.add(new Book(1, "자바 디자인 패턴"));
		books.add(new Book(2, "자바 EE 기초"));
		books.add(new Book(3, "이것이 자바다"));
	}
	
	public List<Book> getAllBooks() {
		return books;
	}

	public Book getBookByIsbn(int isbn) {
		Book returnBook = null;
		for(Book book : books) {
			if(book.getIsbn() == isbn) {
				returnBook = book;
			}
		}
		return returnBook;
	}

	public void saveBook(Book book) {
		books.add(book);
	}

	public void deleteBook(Book book) {
		books.remove(book);
	}

}
