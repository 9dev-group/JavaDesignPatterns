package Problem02;

import java.util.ArrayList;
import java.util.stream.Collectors;

public enum BookManager {
    INSTANCE;

    private ArrayList<Book> library = new ArrayList<>();

    BookManager() {
        library.add(new Book(
                "가장 빨리 만나는 코어 자바 9",
                "카이 호스트만",
                "자바",
                "9791160504392"
        ));
        library.add(new Book(
                "자바 EE 디자인 패턴",
                "무라트 예네르,알렉스 시돔",
                "자바,디자인 패턴",
                "9791160501285"
        ));
    }

    public ArrayList<Book> findByTitle(String query) {
        return library.stream()
                .filter(book -> book.getTitle().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Book> findByAuthor(String query) {
        return library.stream()
                .filter(book -> book.getAuthor().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Book> findByCategory(String query) {
        return library.stream()
                .filter(book -> book.getCategory().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Book> findByISBN(String query) {
        return library.stream()
                .filter(book -> book.getISBN().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
