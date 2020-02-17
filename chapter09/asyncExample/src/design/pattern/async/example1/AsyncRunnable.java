package design.pattern.async.example1;

//Runnable 인터페이스를 구현해서 비동기 코드 작성
public class AsyncRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("실행 중");
	}

}
