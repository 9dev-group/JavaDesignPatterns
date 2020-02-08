package Problem02;

public class Book {
    private String title;
    private String author;
    private String category;
    private String ISBN;

    Book(String title, String author, String category, String ISBN) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getISBN() {
        return ISBN;
    }
}
