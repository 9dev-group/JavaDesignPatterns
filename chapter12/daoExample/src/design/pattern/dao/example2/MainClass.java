package design.pattern.dao.example2;

public class MainClass {
	public static void main(String[] args) {
		MyDao dao = new MyDao();
		MyDto dto = new MyDto();
		dto.setName("홍길동");
		dto.setAge(20);
		dao.insert(dto);
		dao.select();
	}
}
