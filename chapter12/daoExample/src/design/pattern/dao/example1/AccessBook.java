package design.pattern.dao.example1;

//DAO를 통해 비즈니스 로직에서 데이터를 사용하는 예제
public class AccessBook {
  public static void main(String[] args) {
	 BookDao bookDao = new BookDaoImpl();
	 System.out.println("전체 책 정보를 가져옵니다...");
	 for(Book book : bookDao.getAllBooks()) {
		 System.out.println("Book ISBN : " + book.getIsbn() + " | Book Name : " + book.getBookName());
	 }
	 
	 System.out.println("책 정보를 입력합니다...");
	 Book book = new Book();
	 book.setIsbn(4);
	 book.setBookName("알고리즘 익히기");
	 bookDao.saveBook(book);
	 for(Book book2 : bookDao.getAllBooks()) {
		 System.out.println("Book ISBN : " + book2.getIsbn() + " | Book Name : " + book2.getBookName());
	 }
	 
	 System.out.println("책 정보를 삭제합니다...");
	 Book bookForDelete = bookDao.getBookByIsbn(2);
	 bookDao.deleteBook(bookForDelete);
	 for(Book book3 : bookDao.getAllBooks()) {
		 System.out.println("Book ISBN : " + book3.getIsbn() + " | Book Name : " + book3.getBookName());
	 }
  }
}
