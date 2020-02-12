package Problem02;

import java.util.ArrayList;

public class Problem02 {
    public static void main(String[] args) {
        BookManager bookManager = BookManager.INSTANCE;

        ArrayList<Book> books = bookManager.findByTitle("자바");
        books.forEach(book -> System.out.println(book.getTitle()));

        books = bookManager.findByAuthor("카이 호스트만");
        books.forEach(book -> System.out.println(book.getAuthor()));

        books = bookManager.findByCategory("디자인 패턴");
        books.forEach(book -> System.out.println(book.getCategory()));

        books = bookManager.findByISBN("9791160501285");
        books.forEach(book -> System.out.println(book.getISBN()));
    }
}
