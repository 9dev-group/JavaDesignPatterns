package design.pattern.async.example1;

//스레드 클래스를 상속받아 비동기 코드 작성
public class HelloThread extends Thread{

	public void run() {
		System.out.println("실행 중! ... in HelloThread");
	}
}
