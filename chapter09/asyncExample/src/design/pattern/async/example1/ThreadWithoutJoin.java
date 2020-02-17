package design.pattern.async.example1;

public class ThreadWithoutJoin {

	//메인이 끝나면 모든게 종료되는게 아님
	//쓰레드는 메인이 종료되어도 백그라운드에서 작동
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "start");
		Runnable r = new MyRunnable();
		Thread thread = new Thread(r);
		thread.start();
		System.out.println(Thread.currentThread().getName() + "end");
	}
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
      System.out.println("1단계");
      thread2();
	}
	
	public void thread2() {
	  System.out.println("2단계");
	  thread3();
	}
	
	public void thread3() {
	  System.out.println("3단계");
	}
}
